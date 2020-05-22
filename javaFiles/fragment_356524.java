JNIEXPORT jint JNICALL
Java_com_package_MyClass_nativeMethod(JNIEnv* env, jclass klass, jbyteArray array) {
    jboolean isCopy;
    jint length = (*env)->GetArrayLength(env, array);
    jbyte* buf = (*env)->GetByteArrayElements(env, array, &isCopy);
    jint result = process(buf, length);
    (*env)->ReleaseByteArrayElements(env, array, buf, JNI_ABORT);
    return result;    
}