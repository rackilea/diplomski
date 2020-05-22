JavaVM* g_jvm;

jint JNI_OnLoad(JavaVM* vm, void* reserved)
{
    g_jvm = vm;
    JNIEnv* env;
    if (vm->GetEnv(reinterpret_cast<void**>(&env), JNI_VERSION_1_6) != JNI_OK) {
        return -1;
    }

    // Get jclass with env->FindClass.
    // Register methods with env->RegisterNatives.

    return JNI_VERSION_1_6;
}

JNIEnv* getJNIEnv() {
    JNIEnv* env;
    g_jvm->GetEnv(reinterpret_cast<void**>(&env), JNI_VERSION_1_6 /*version*/);
    return env;
}