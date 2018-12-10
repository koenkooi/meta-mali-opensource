DESCRIPTION = "EGL test"
LICENSE = "GPLv2"
DEPENDS = "virtual/libgles2 virtual/egl libdrm"

LIC_FILES_CHKSUM = "file://egl.cpp;md5=439673fa12b6b20a7b904a6b4e64e61a"

SRC_URI = "file://egl.cpp"

S = "${WORKDIR}/egl"

inherit distro_features_check

REQUIRED_DISTRO_FEATURES = "opengl"

do_unpack() {
	install -d ${S}
	cp ${WORKDIR}/*cpp ${S}
}

do_compile() {
	$CXX -o eglconfigtest egl.cpp -lEGL -lgbm
}
