// Obtain a device ID 
    cl_device_id devices[] = new cl_device_id[numDevices];
    clGetDeviceIDs(platform, deviceType, numDevices, devices, null);
    cl_device_id device = devices[deviceIndex];
 //one of devices[] element must be your HD3000.Example: devices[0]->gpu devices[1]->cpu 
 //devices[2]-->HD3000