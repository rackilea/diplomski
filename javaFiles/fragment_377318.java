JNIEXPORT jobjectArray JNICALL
Java_org_opencv_samples_fd_DetectionBasedTracker_nativeCreateObject
(JNIEnv *env, jclass cls, jstring str, jint count){

    // cls argument - is DetectionBasedTracker.class

    // take class info
    jclass matCls = env->FindClass("your/package/Mat");
    if (env->ExceptionOccurred())
        return NULL;

    // take constructor by signature
    const char* constructorSignature = "(Ljava/lang/String;)V";
    jmethodID constructor = env->GetMethodID(matCls, "<init>", constructorSignature);
    if (env->ExceptionOccurred())
        return NULL;

    // create java objects array
    jobjectArray matArray = env->NewObjectArray((jsize)count, matCls, NULL);
    for(jsize i = 0; i < count; i++){
        // create new object
        jobject mat = env->NewObject(matCls, constructor, /* constructor args */ str);
        // put object into array
        env->SetObjectArrayElement(matArray , i, mat);
    }

    return matArray;
}