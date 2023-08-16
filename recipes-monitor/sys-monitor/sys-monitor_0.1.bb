
SUMMARY = "Python gRPC Linux System Monitor"
DESCRIPTION = "${SUMMARY}"

LICENSE = "CLOSED"

SRC_URI = "git://git@github.com:/SouhaChabir/MonitoringOfLinuxSystem.git;protocol=ssh;branch=Internship_Project"
SRCREV = "dfebc33998f910e3c9c88d58a9412c499d53f3f3"

S = "${WORKDIR}/git"

inherit python3native

do_configure[noexec] = "1"

do_compile(){
    export PYTHONPATH="${WORKDIR}/recipe-sysroot-native/${PYTHON_SITEPACKAGES_DIR}"
    python3 -m grpc_tools.protoc -Iprotos --python_out=lib/ --grpc_python_out=lib/ sys_monitor.proto
}

DEPENDS += "python3-grpcio-tools-native"

do_install(){
    install -d ${D}/opt/sys_monitor
    cp -r * ${D}/opt/sys_monitor
}

RDEPENDS:${PN} += "bash \
        python3-psutil \
        python3-protobuf \
        python3-grpcio \
        python3-grpcio-tools"

FILES:${PN} += "/opt/*"