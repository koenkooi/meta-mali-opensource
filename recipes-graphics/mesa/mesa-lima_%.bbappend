# Enable lima for meson
PACKAGECONFIG_append_aarch64 = " gallium"
PACKAGECONFIG_remove_aarch64 = " vulkan"
GALLIUMDRIVERS_aarch64 = "meson,lima,freedreno,etnaviv,swrast,imx,rockchip,sun4i"
DRIDRIVERS_aarch64 = ""
