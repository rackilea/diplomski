JNIEXPORT jstring JNICALL Java_bla_bla_bla(JNIEnv *env, jclass java_class, jint param) {
    JavaVM *jvm;
    if (env->GetJavaVM(&jvm)) {
        // Something went wrong
    }
    // Pass jvm to the new thread