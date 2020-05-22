jobject mainClass;

jstring spname(JNIEnv *env) {
    return env->NewStringUTF("sharedstore");
}

jstring objectname(JNIEnv *env) {
    return env->NewStringUTF("boolvaluestore");
}

extern "C"
JNIEXPORT jboolean JNICALL
Java_com_ebizzinfotech_amjad_contentresolverproj_MainActivity_getStoreValues(JNIEnv *env,
                                                                             jobject instance,
                                                                             jobject activity) {

    jclass spcls = env->FindClass("android/content/SharedPreferences");
    jclass contextcls = env->FindClass("android/content/Context");
    mainClass = env->NewGlobalRef(activity);
    jmethodID mid = env->GetMethodID(contextcls, "getSharedPreferences",
                                     "(Ljava/lang/String;I)Landroid/content/SharedPreferences;");
    jmethodID midbool = env->GetMethodID(spcls, "getBoolean",
                                         "(Ljava/lang/String;Z)Z");
    jobject jobjectshared = env->CallObjectMethod(mainClass, mid, spname(env), 0);
//    jobject jobjectsharededit  = env->CallObjectMethod(jobjectshared,midedit);
    jboolean jboolean1 = env->CallBooleanMethod(jobjectshared, midbool,objectname(env), JNI_FALSE);

    env->DeleteLocalRef(spcls);
    env->DeleteLocalRef(contextcls);
    return jboolean1;
}


extern "C"
JNIEXPORT void JNICALL
Java_com_ebizzinfotech_amjad_contentresolverproj_MainActivity_setStoreBoolValues(JNIEnv *env,
                                                                                 jobject instance,
                                                                                 jobject activity,
                                                                                 jboolean flag) {
    jclass spcls = env->FindClass("android/content/SharedPreferences");
    jclass speditorcls = env->FindClass("android/content/SharedPreferences$Editor");
    jclass contextcls = env->FindClass("android/content/Context");

    mainClass = env->NewGlobalRef(activity);

    jmethodID mid = env->GetMethodID(contextcls, "getSharedPreferences",
                                     "(Ljava/lang/String;I)Landroid/content/SharedPreferences;");

    jmethodID midedit = env->GetMethodID(spcls, "edit",
                                         "()Landroid/content/SharedPreferences$Editor;");

    jmethodID midputbool = env->GetMethodID(speditorcls, "putBoolean",
                                            "(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;");

    jmethodID midapply = env->GetMethodID(speditorcls, "apply",
                                          "()V");
    jobject jobjectshared = env->CallObjectMethod(mainClass, mid,spname(env), 0);
    jobject jobjectsharededit = env->CallObjectMethod(jobjectshared, midedit);
    env->CallVoidMethod(env->CallObjectMethod(jobjectsharededit, midputbool, objectname(env), flag),
                        midapply);
    env->DeleteLocalRef(spcls);
    env->DeleteLocalRef(contextcls);
    env->DeleteLocalRef(speditorcls);
}