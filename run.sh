#!/bin/bash
# Author - Suraj Ajjampur
# Script to flash the image onto an NVIDIA Jetson Nano device for a Deepstream Docker example

# Navigates to where the image and flash scripts are located
cd build/

# This is where we will place the files needed for flashing
sudo rm -rf deploy/
mkdir deploy
cd deploy/

# Create a symbolic link for the .tar.gz image file from the tmp/deploy/images directory
# This step assumes that the build process has been completed and the deployable image is present in the specified path
ln -s ../tmp/deploy/images/jetson-nano-2gb-devkit/demo-image-full-jetson-nano-2gb-devkit.tegraflash.tar.gz

# Extract the contents of the image tarball, which includes the flashing utilities and the binary image itself
tar -xvf demo-image-full-jetson-nano-2gb-devkit.tegraflash.tar.gz

# Execute the doflash.sh script with superuser privileges to flash the image onto the Jetson Nano
# The device should be in recovery mode and connected to the host machine for the flash to succeed
sudo ./doflash.sh
