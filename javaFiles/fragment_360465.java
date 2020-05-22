extern "C"
JNIEXPORT jstring JNICALL 
Java_com_android_mycax_luckynumbers_MainActivity_Calculate (JNIEnv *env, jobject, jstring cFirstName, jstring cLastName) {
    const char *path = env->GetStringUTFChars(cFirstName, NULL);
    const char *path2 = env->GetStringUTFChars(cLastName, NULL);
    FrNmFromJava = ToString(path);
    LstNmFromJava = ToString(path2);
    LuckyNumbersProcess(FrNmFromJava, LstNmFromJava);
    std::string sLuckyNumber = ToString(LuckyNumber);
    ClearAll();
    return env->NewStringUTF(sLuckyNumber.c_str());
}