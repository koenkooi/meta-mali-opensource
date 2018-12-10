#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <errno.h>
#include <string.h>

#include <EGL/egl.h>
#include <gbm.h>

const EGLint attribute_list[] =
{
//  EGL_RED_SIZE, 8,
//  EGL_GREEN_SIZE, 8,
//  EGL_BLUE_SIZE, 8,
//  EGL_ALPHA_SIZE, 2,
//  EGL_DEPTH_SIZE, 16,
//  EGL_STENCIL_SIZE, 0,
//  EGL_SAMPLE_BUFFERS, 0,
//  EGL_SAMPLES, 0,
  EGL_SURFACE_TYPE, EGL_WINDOW_BIT,
  EGL_RENDERABLE_TYPE, EGL_OPENGL_ES2_BIT,
  EGL_NONE
};

#define X(VAL) {VAL, #VAL}
struct {EGLint attribute; const char* name;} names[] = {
    //X(EGL_BUFFER_SIZE),
    X(EGL_RED_SIZE),
    X(EGL_GREEN_SIZE),
    X(EGL_BLUE_SIZE),
    X(EGL_ALPHA_SIZE),
    // X(EGL_CONFIG_CAVEAT),
    // X(EGL_CONFIG_ID),
    X(EGL_DEPTH_SIZE),
    // X(EGL_LEVEL),
    // X(EGL_MAX_PBUFFER_WIDTH),
    // X(EGL_MAX_PBUFFER_HEIGHT),
    // X(EGL_MAX_PBUFFER_PIXELS),
    // X(EGL_NATIVE_RENDERABLE),
    X(EGL_NATIVE_VISUAL_ID),
    // X(EGL_NATIVE_VISUAL_TYPE),
    // X(EGL_PRESERVED_RESOURCES),
    // X(EGL_SAMPLE_BUFFERS),
    X(EGL_SAMPLES),
    // X(EGL_STENCIL_SIZE),
    // X(EGL_SURFACE_TYPE),
    // X(EGL_TRANSPARENT_TYPE),
    // X(EGL_TRANSPARENT_RED),
    // X(EGL_TRANSPARENT_GREEN),
    // X(EGL_TRANSPARENT_BLUE)
    };
#undef X

int main()
{
  EGLDisplay display;
  EGLConfig *configs;
  EGLContext context;
  EGLint num_configs;
  EGLint num_matched;

  int fd = open("/dev/dri/renderD128", O_RDONLY);

  if (fd < 0)
  {
    printf("failed to open drm device: %s\n", strerror(errno));
    return -1;
  }

  gbm_device *gbm_device = gbm_create_device(fd);

  display = eglGetDisplay(reinterpret_cast<EGLNativeDisplayType>(gbm_device));

  eglInitialize(display, NULL, NULL);

  eglGetConfigs(display, nullptr, 0, &num_configs);

  configs = new EGLConfig[num_configs * sizeof(EGLConfig)];

  eglChooseConfig(display, attribute_list, configs, num_configs, &num_matched);

  printf("matched configs: %d\n", num_matched);

  for (int i = 0; i < num_matched; i++)
  {
    printf("\nconfig: %d\n", i);

    for (int j = 0; j < sizeof(names) / sizeof(names[0]); j++)
    {
      EGLint value{-1};

      if (eglGetConfigAttrib(display, configs[i], names[j].attribute, &value) == EGL_TRUE)
        printf("  %s: %d (0x%04x)\n", names[j].name, value, value);
    }
  }

  delete [] configs;
}
