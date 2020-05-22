JNIEXPORT jint JNICALL
    Java_test__NativeCall
                    (JNIEnv *env, 
                    jobject callingObject)
    {
    int sample=10;
    return (jint)sample;
    }