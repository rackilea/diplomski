int a=0;
clSetKernelArg(kernel, a++, 
    Sizeof.cl_mem, Pointer.to(memObjects[0]));
clSetKernelArg(kernel, a++, 
    Sizeof.cl_mem, Pointer.to(memObjects[1]));
clSetKernelArg(kernel, a++, 
    Sizeof.cl_mem, Pointer.to(memObjects[2]));

// These have been missing:
clSetKernelArg(kernel, a++, 
    Sizeof.cl_int, Pointer.to(new int[]{ wA }));
clSetKernelArg(kernel, a++, 
    Sizeof.cl_int, Pointer.to(new int[]{ wB }));