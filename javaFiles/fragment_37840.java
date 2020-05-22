Java_com_de_demo_ndk2_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject jobject1, jstring jstring1) {

    std::string hello;
    const char *nativeString1 = env->GetStringUTFChars( jstring1, 0);
    if (strcmp(nativeString1, "demo") == 0) {
        hello = "Hello from demo C++";
    } else if (strcmp(nativeString1, "live") == 0) {
        hello = "Hello from live C++";
    }

    return env->NewStringUTF(hello.c_str());
}