![Build status](https://builder.madison.systems/badges/tegrademo-dunfell-32-7.svg)

# Jetson-project
This is the repo for the Jetson Nano Project using the DeepStream SDK to classify objects.
The team members are:
* Erick Reyes - erick.reyes@colorado.edu
* Shreeyash Nadella - shreeyash.nadella@colorado.edu

# Yocto Build Repository
https://github.com/cu-ecen-aeld/final-project-shna6159

# Project Overview
https://github.com/ericksyndrome/Jetson-project/wiki/Project-Overview

# Project Schedule
https://github.com/users/ericksyndrome/projects/2/views/1?groupedBy%5BcolumnId%5D=85235952

# Project Issues
https://github.com/cu-ecen-aeld/final-project-ErickSyndrome/issues

https://github.com/cu-ecen-aeld/final-project-shna6159/issues

# Building the Application Code

# Building the OS Image
Given below are the instruction to build the OS Image

```
git clone git@github.com:cu-ecen-aeld/final-project-shna6159.git
source setup-env --machine jetson-nano-devkit
bitbake demo-image-full
```
