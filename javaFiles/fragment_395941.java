"__kernel void "
        + "sampleKernel(__global uint *a,"
        + "             __global uint *c)"
        + "{"
        + "__private uint intensity_core=0;" <---this is a private variable of each core
        + "      uint i = get_global_id(0);"
        + "      for(uint j=i*90000; j < (i+1)*90000; j++){ "
        + "              intensity_core += a[j];" <---register is at least 100x faster than global memory
         //but we cannot get rid of a[] so the calculation time cannot be less than %50
        + "     }"
        + "c[i]=intensity_core;"   
        + "}";  //expecting %100 speedup