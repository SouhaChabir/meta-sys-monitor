
require recipes-core/images/core-image-minimal.bb

IMAGE_INSTALL:append = " sys-monitor"
IMAGE_FEATURES:append = " ssh-server-openssh"