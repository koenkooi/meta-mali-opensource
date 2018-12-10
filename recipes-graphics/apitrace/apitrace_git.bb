SUMMARY = "Tools for tracing OpenGL, Direct3D, and other graphics APIs http://apitrace.github.io/"

DEPENDS = "zlib libpng procps virtual/libx11"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=aeb969185a143c3c25130bc2c3ef9a50"

SRCREV = "711b198a0ff2b60e52808003de395bc1b6e9da4d"
SRC_URI = "git://github.com/apitrace/apitrace.git;protocol=https"

S = "${WORKDIR}/git"

inherit cmake pkgconfig perlnative pythonnative

PACKAGECONFIG ??= ""

PACKAGECONFIG[multiarch] = "-DENABLE_MULTIARCH=ON,-DENABLE_MULTIARCH=OFF"
PACKAGECONFIG[waffle] = "-DENABLE_WAFFLE=ON,-DENABLE_WAFFLE=OFF,waffle"
PACKAGECONFIG[x11] = "-DDISABLE_X11=OFF,-DDISABLE_X11=ON,virtual/libx11"
PACKAGECONFIG[x11-egl] = "-Dwaffle_has_x11_egl=ON,-Dwaffle_has_x11_egl=OFF"
PACKAGECONFIG[vivante] = "-DENABLE_VIVANTE=ON,-DENABLE_VIVANTE=OFF,virtual/libg2d"

FILES_${PN}-dbg += "${libdir}/*/*/.debug"
