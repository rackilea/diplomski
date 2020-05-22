jobjectArray result = NULL;
for (int i = 0 ; i < num_byte_arrays ; i++) {
    jbyteArray byte_array = java_env->NewByteArray(3);
    if (i == 0) {
        result = java_env->NewObjectArray(num_byte_arrays, java_env->GetObjectClass(byte_array), NULL);
    }
    java_env->SetObjectArrayElement(result, i, byte_array);
}