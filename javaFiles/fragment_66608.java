void handler(int s) {
    if(jvm == NULL)
        return ;
    if(callback == NULL)
        return ;

    JNIEnv *env = NULL;
    jint res;
    res = (*jvm)->AttachCurrentThread(jvm, (void **)&env, NULL);
    if(res < 0)
    {
        fprintf(stderr, "Attach VM Thread failed\n");
        return ;
    }

    jclass cls = (*env)->GetObjectClass(env, callback);
    jmethodID mid = (*env)->GetMethodID(env, cls, "run", "()V");
    (*env)->CallVoidMethod(env, callback, mid);
    (*jvm)->DetachCurrentThread(jvm);
}