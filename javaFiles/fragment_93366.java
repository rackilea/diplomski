JNIEXPORT void JNICALL Java_accessBuffThroughObjectTwo(JNIEnv *env, jobject obj,  jobject objectTwo) {
    jclass clazz;
    jclass bufferClazz;
    jobject bufferJObject;
    jfieldID fid;

    clazz = (*env)->GetObjectClass(env, objectTwo);
    assert(clazz != NULL);
    fid = (*env)->GetFieldID(env, clazz, "obj", "Ljava/lang/Object;");
    assert(fid != NULL);
    bufferJObject = (*env)->GetObjectField(env, javascsicommand, fid);
    assert(bufferJObject != NULL);
    bufferClazz = (*env)->GetObjectClass(env, bufferJObject);
    assert(bufferClazz != NULL);
    fid = (*env)->GetFieldID(env, bufferClazz, "buff", "[B");
    assert(fid != NULL);
}