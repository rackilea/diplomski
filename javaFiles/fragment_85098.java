JNIEXPORT jobject JNICALL Java_com_sample_getMyObject(JNIEnv *env, jobject obj) {
    jclass clz = (*env)->GetObjectClass(env, obj);
    // .. doing something
    jobject lRefObj = (*env)->NewLocalRef(env, gRefObj);

    (*env)->DeleteGlobalRef(env, gRefObj);  
    (*env)->DeleteLocalRef(env, clz);
    return lRefObj;
}