SUMMARY = "bitbake-layers recipe"
DESCRIPTION = " program to print hell Mr. Shindy!"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=39346640a23c701e4f459e05f56f4449"

SRC_URI = "file://helloworld.c"

S = "${WORKDIR}/build"

do_compile() {
    ${CC} ${CFLAGS} ${LDFLAGS} ${WORKDIR}/helloworld.c -o ${S}/helloworld
}
do_install() {
    install -d ${D}${bindir}/
    install -m 0755 -${S}/helloworld ${D}${bindir}/
}
