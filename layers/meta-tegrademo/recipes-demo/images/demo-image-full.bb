# Basic image description
DESCRIPTION = "Full Tegra demo image with X11/Sato, nvidia-docker, OpenCV, \
VPI samples, TensorRT samples, and Tegra multimedia API sample apps."

# Include common settings from another file
require demo-image-common.inc

# Splash screen, X11 windowing system, Sato (a mobile environment), hardware codecs
IMAGE_FEATURES += "splash x11-base x11-sato hwcodecs"

# Inherit additional metadata features
inherit features_check

# Define required distro features
REQUIRED_DISTRO_FEATURES = "x11 opengl virtualization" 
# X11 for graphical interface, OpenGL for 3D acceleration, virtualization for VM support

# Core components to be installed in the base image
# User Interface and Testing packages
CORE_IMAGE_BASE_INSTALL += "packagegroup-demo-x11tests" 
# X11 test utilities and applications

# Conditional Vulkan support
CORE_IMAGE_BASE_INSTALL += "${@bb.utils.contains('DISTRO_FEATURES', 'vulkan', 'packagegroup-demo-vulkantests', '', d)}" 
# Vulkan tests if the Vulkan feature is enabled

# NVIDIA and GPU related packages
CORE_IMAGE_BASE_INSTALL += "libvisionworks-devso-symlink nvidia-docker cuda-libraries tegra-mmapi-tests vpi1-tests tensorrt-tests" 
# NVIDIA VisionWorks, Docker integration, CUDA libraries, Tegra Multimedia API, Vision Programming Interface tests, TensorRT tests

# Development tools and utilities
CORE_IMAGE_BASE_INSTALL += "cuda-cudart-dev git gcc make kernel-module-uvcvideo v4l-utils netcat" 
# CUDA runtime, Git, GCC, Make, UVC video kernel module, Video4Linux utilities, Netcat

# GPIO utilities
CORE_IMAGE_BASE_INSTALL += "gpio gpioservice gpioapplication" 
# GPIO tools and services, custom GPIO application

# Network and system utilities
CORE_IMAGE_BASE_INSTALL += "python3 ntp wpa-supplicant fbida fbgrab ffmpeg imagemagick gstreamer1.0 " 
# Python 3, NTP for time synchronization, Wi-Fi tools, image viewers and capture, FFmpeg multimedia framework, ImageMagick for image conversion, base GStreamer framework

# Additional GStreamer plugins (to be installed)
# Multimedia and streaming plugins
CORE_IMAGE_BASE_INSTALL += "gstreamer1.0-plugins-good gstreamer1.0-plugins-base" 
# GStreamer plugins for good-quality plugins and base functionalities

# More GStreamer plugins for additional support
CORE_IMAGE_BASE_INSTALL += "gstreamer1.0-plugins-ugly gstreamer1.0-libav gst-player" 
# Plugins with potential legal implications, libav plugin, GStreamer player

# GStreamer base meta-package and examples
CORE_IMAGE_BASE_INSTALL += "gstreamer1.0-meta-base gst-examples" 
# GStreamer base meta-package, examples for GStreamer usage

# RTSP server plugin for GStreamer
CORE_IMAGE_BASE_INSTALL += "gstreamer1.0-rtsp-server" 
# Plugin to enable RTSP server capabilities in GStreamer
