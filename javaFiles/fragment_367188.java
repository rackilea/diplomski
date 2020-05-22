// determine the needed length and allocate a buffer for it
jsize num_bytes = GetArrayLength(env, array);
char *buffer = malloc(num_bytes + 1);

if (!buffer) {
    // handle allocation failure ...
}

// obtain the array elements
jbyte* elements = GetByteArrayElements(env, array, NULL);

if (!elements) {
    // handle JNI error ...
}

// copy the array elements into the buffer, and append a terminator
memcpy(buffer, elements, num_bytes);
buffer[num_bytes] = 0;

// Do not forget to release the element array provided by JNI:
ReleaseByteArrayElements(env, array, elements, JNI_ABORT);