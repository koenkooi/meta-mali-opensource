SUMMARY = "Tools for tracing OpenGL, Direct3D, and other graphics APIs http://apitrace.github.io/"

DEPENDS = "zlib libpng procps virtual/libx11 virtual/libgl protobuf-native protobuf"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=aeb969185a143c3c25130bc2c3ef9a50"

SRCREV = "cf11139d6a05688b55c3ab08844a4c9c3c736ea2"
SRC_URI = "git://github.com/janesma/apitrace.git;protocol=https;branch=frameretrace"

S = "${WORKDIR}/git"

inherit cmake pkgconfig perlnative pythonnative

PACKAGECONFIG ??= ""

PACKAGECONFIG[multiarch] = "-DENABLE_MULTIARCH=ON,-DENABLE_MULTIARCH=OFF"
PACKAGECONFIG[waffle] = "-DENABLE_WAFFLE=ON,-DENABLE_WAFFLE=OFF,waffle"
PACKAGECONFIG[x11] = "-DDISABLE_X11=OFF,-DDISABLE_X11=ON,virtual/libx11"
PACKAGECONFIG[x11-egl] = "-Dwaffle_has_x11_egl=ON,-Dwaffle_has_x11_egl=OFF"
PACKAGECONFIG[vivante] = "-DENABLE_VIVANTE=ON,-DENABLE_VIVANTE=OFF,virtual/libg2d"

FILES_${PN}-dbg += "${libdir}/*/*/.debug"
