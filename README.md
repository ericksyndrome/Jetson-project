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

# Pre-requisites: 
* Connect the wifi dongle on the Jetson Nano and ensure you have a wireless network connection established
* Connect the Logitech C270HD WEBCAM 

Perform the steps given below to build the application code:

1. Open a terminal and run the step given below:
```
vi /etc/docker/daemon.json
```
2. Modify the docker runtime file at /etc/docker/daemon.json to look like this:
```
{
    "runtimes": {
        "nvidia": {
            "path": "nvidia-container-runtime",
            "runtimeArgs": []
        }
    },
    "default-runtime" : "nvidia"
}
```

3. Run the command given below to allow the docker to pick up the configuration:
```
systemctl restart docker
```
4. Clone this repository by using the command given below:
```
git clone git@github.com:ericksyndrome/Jetson-project.git
```
5. Build and Run the docker container by running the following commands:
```
cd Jetson-project
./docker/build.sh
./docker/run.sh
```

Note: The run.sh might need to be re-executed untill you see something like the picture below on your terminal:
```
**PERF:  4.50 (6.53)
Frame Number = 8 of Stream = 0,   LineCrossing Cumulative peds = 0 LineCrossing Cumulative lane1 = 0 LineCrossing Current Frame peds = 0 LineCrossing Current Frame lane1 = 0
Frame Number = 9 of Stream = 0,   LineCrossing Cumulative peds = 0 LineCrossing Cumulative lane1 = 0 LineCrossing Current Frame peds = 0 LineCrossing Current Frame lane1 = 0
Frame Number = 10 of Stream = 0,   LineCrossing Cumulative peds = 0 LineCrossing Cumulative lane1 = 0 LineCrossing Current Frame peds = 0 LineCrossing Current Frame lane1 = 0
Frame Number = 11 of Stream = 0,   LineCrossing Cumulative peds = 0 LineCrossing Cumulative lane1 = 0 LineCrossing Current Frame peds = 0 LineCrossing Current Frame lane1 = 0
Frame Number = 12 of Stream = 0,   LineCrossing Cumulative peds = 0 LineCrossing Cumulative lane1 = 0 LineCrossing Current Frame peds = 0 LineCrossing Current Frame lane1 = 0
**PERF:  4.83 (5.79)
```

6. Examine the output
- While the video gets processed, see the following output. 
- Open the video present at "data-default/output/video.mp4". And you should see a video like this:


# Building the OS Image
Given below are the instruction to build the OS Image

```
git clone git@github.com:ericksyndrome/Jetson-project.git
source setup-env --machine jetson-nano-devkit
bitbake demo-image-full
```
