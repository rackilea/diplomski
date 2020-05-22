/*Flush all the bits in the struct so we can decode a new frame*/
speex_bits_reset(&decod_bits);

/*Read bits in decod_bits struct from java array*/
speex_bits_read_from(&decod_bits,(char *) inputArrayElements, nbBytes);

/*Copy the bits to an array of char that can be written*/
nbBytes = speex_bits_nbytes(&decod_bits);
ret = (jshortArray)((*env)->NewShortArray(env, nbBytes));
jshort * arrayElements = (*env)->GetShortArrayElements(env, ret, 0);

/*Decode the frame*/
speex_decode_int(decod_state, &decod_bits, arrayElements);

(*env)->ReleaseCharArrayElements(env, inputCharData, inputArrayElements,
        JNI_ABORT);
(*env)->ReleaseShortArrayElements(env, ret, arrayElements, 0);
return ret;