require ${PN}.inc

PATCHTOOL = "git"
PATCH_COMMIT_FUNCTIONS = "1"

SRC_URI = "git://gitlab.freedesktop.org/mesa/mesa.git;protocol=https;branch=18.3 \
           file://0001-Makefile.vulkan.am-explictly-add-lib-expat-to-intel-.patch \
           file://0003-winsys-svga-drm-Include-sys-types.h.patch \
           file://0004-hardware-gloat.patch \
           file://0005-Properly-get-LLVM-version-when-using-LLVM-Git-releas.patch \
           \
           file://lima/0001-gallium-u_math-add-ushort_to_float-float_to_ushort.patch \
           file://lima/0002-nir-add-load-uniform-lower-to-scalar.patch \
           file://lima/0003-u_dynarray-add-util_dynarray_enlarge.patch \
           file://lima/0004-gallium-add-a-cap-to-force-compute-minmax-indices.patch \
           file://lima/0005-drm-uapi-forcc-add-ARM-tiled-modifier-format.patch \
           file://lima/0006-drm-uapi-add-lima_drm.h.patch \
           file://lima/0007-gallium-add-lima-driver.patch \
           file://lima/0008-gallium-add-sun4i-driver.patch \
           file://lima/0009-gallium-add-exynos-driver.patch \
           file://lima/0010-gallium-add-meson-driver.patch \
           file://lima/0011-gallium-add-rockchip-driver.patch \
           file://lima/0012-lima-use-WINSYS_HANDLE_-for-18.2-rebase.patch \
           file://lima/0013-lima-is_format_supported-changed-in-18.2.patch \
           file://lima/0014-egl-glx-query-dri-integer-to-expose-EGL-GLX_EXT_buff.patch \
           file://lima/0015-gallium-add-PIPE_CAP_BUFFER_AGE.patch \
           file://lima/0016-egl-fix-query-buffer-age-fail-when-EGL_KHR_partial_u.patch \
           file://lima/0017-egl-android-Delete-set_damage_region-from-egl-dri-vt.patch \
           file://lima/0018-dri_interface-add-an-interface-for-setting-damage-re.patch \
           file://lima/0019-egl-dri-Use-__DRI2_DAMAGE-extension-for-KHR_partial_.patch \
           file://lima/0020-st-dri2-use-dynamic-alloc-extensions.patch \
           file://lima/0021-gallium-add-PIPE_CAP_SET_DAMAGE.patch \
           file://lima/0022-st-dri2-add-optional-dri2DamageExtension.patch \
           file://lima/0023-lima-add-lima_set_damage_region.patch \
           file://lima/0024-lima-mali450-be-able-to-not-use-dlbu.patch \
           file://lima/0025-Revert-lima-initial-implementation-for-no-glClear-dr.patch \
           file://lima/0026-lima-fix-texture-wrap_t-parameter.patch \
           file://lima/0027-lima-seperate-lima_texture_desc_set_res.patch \
           file://lima/0028-lima-reload-FB-tile-buffer-when-glFlush-without-glCl.patch \
           file://lima/0029-lima-set-damage-with-tile-buffer-region.patch \
           file://lima/0030-lima-implement-EGL_KHR_partial_update.patch \
           file://lima/0031-lima-ir-print-name-of-unsupported-nir_op.patch \
           file://lima/0032-lima-clear-add-command-stream-directly.patch \
           file://lima/0033-lima-implement-partial-clear.patch \
           file://lima/0034-lima-ppir-fix-bitcopy-bug.patch \
           file://lima/0035-lima-use-PLBU_CMD-for-plbu-command-stream-constructi.patch \
           file://lima/0036-lima-use-VS_CMD-for-vs-command-stream-construction.patch \
           file://lima/0037-lima-move-update-submit-bo-to-the-begin-of-a-draw-cl.patch \
           file://lima/0038-lima-fix-mtx_lock-Assertion-mtx-NULL-failed.patch \
           file://lima/0039-lima-fix-LIMA_DUMP_COMMAND_STREAM-fail.patch \
           file://lima/0040-lima-fix-texture-layout-setting.patch \
           file://lima/0041-lima-gpir-Rename-gpir_lower_funcs.patch \
           file://lima/0042-lima-gpir-add-fnot-op-support.patch \
           file://lima/0043-lima-pp-Add-a-disassembler.patch \
           file://lima/0044-lima-gp-Add-a-disassembler.patch \
           file://lima/0045-lima-pp-Fix-some-whitespace-issues-in-disassembler.patch \
           file://lima/0046-lima-pp-Fix-disassembler-shift-issue.patch \
           file://lima/0047-lima-fix-tiling-untiling-partial-textures.patch \
           file://lima/0048-lima-fix-multi-triangle-index-draw-hang.patch \
           file://lima/0049-lima-gp-Fix-fnot.patch \
           file://lima/0050-lima-fix-src_x-not-initialized.patch \
           file://lima/0051-meson-add-lima-related-build.patch \
           file://lima/0052-lima-support-INT-index-draw.patch \
           file://lima/0053-lima-in-case-index_size-is-an-expression.patch \
           file://lima/0054-lima-fix-glxgears-hang.patch \
           file://lima/0055-lima-fix-gp-pending-uniform-at-wrong-offset.patch \
           file://lima/0056-lima-ppir-add-nir_op_fsqrt-support.patch \
           file://lima/0057-lima-move-context.texture_subdata-to-resource.patch \
           file://lima/0058-lima-fix-glxinfo-crash.patch \
           file://lima/0059-lima-support-GL_POINTS-and-GL_LINE-draw.patch \
           file://lima/0060-lima-distinguish-RGBA-and-RGBX-texture.patch \
           file://lima/0061-lima-fix-framebuffer-shift_w-h-max-calculation.patch \
           file://lima/0062-lima-move-shift_w-h-max-into-conditional-update.patch \
           file://lima/0063-lima-ppir-fix-load-coord-from-const-node-crash-v2.patch \
           file://lima/0064-lima-port-to-18.3.patch \
           file://lima/0065-lima-use-u_pipe_screen_get_param_defaults-helper.patch \
           file://lima/0066-lima-exit-when-wait-fence-error.patch \
           file://lima/0067-lima-ppir-codegen-fix-combine-instruction-dest_modif.patch \
           file://lima/0068-lima-fix-gp-pp-mmu-fault.patch \
           file://lima/0069-lima-fix-const-lowering-when-gbm-surface.patch \
           file://lima/0070-lima-reset-PIPE_CAP_PREFER_BLIT_BASED_TEXTURE_TRANSF.patch \
           file://lima/0071-lima-add-TODO-comments-for-resource-copy.patch \
           file://lima/0072-lima-ppir-support-nir_op_fsat.patch \
           file://lima/0073-lima-fix-vec3-vec1-varying-render-state-setup.patch \
           file://lima/0074-lima-extend-wrapping-possibilities-with-PIPE_TEX_WRA.patch \
           file://lima/0075-lima-set-submit-flag-when-va-instead-of-alloc.patch \
           file://lima/0076-lima-fix-glxgears-crash.patch \
           file://lima/0077-lima-ppir-fix-vector-select-instruction.patch \
          "

PV = "18.3.1+git${SRCPV}"
SRCREV = "d92c9ba789196978ef2b3b332c3a3737211b5e73"

S = "${WORKDIR}/git"

#because we cannot rely on the fact that all apps will use pkgconfig,
#make eglplatform.h independent of MESA_EGL_NO_X11_HEADER
do_install_append() {
    if ${@bb.utils.contains('PACKAGECONFIG', 'egl', 'true', 'false', d)}; then
        sed -i -e 's/^#if defined(MESA_EGL_NO_X11_HEADERS)$/#if defined(MESA_EGL_NO_X11_HEADERS) || ${@bb.utils.contains('PACKAGECONFIG', 'x11', '0', '1', d)}/' ${D}${includedir}/EGL/eglplatform.h
    fi
}
