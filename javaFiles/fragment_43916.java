jlong Java_c_utils_malloc(JNIEnv* env, jclass clazz, jint size) {
    return (jlong) malloc(size);
}

void Java_c_utils_free(JNIEnv* env, jclass clazz, jlong ptr) {
   free((void *) ptr);
}