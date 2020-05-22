JNIEXPORT void JNICALL Java_HelloWorld_print(JNIEnv *jenv, jobject obj, jstring path)
 {
    char* arg2 = 0;
    if (path) {
       arg2 = (char *)(*jenv)->GetStringUTFChars(jenv, path, 0);
       if (!arg2) return;
    }

    printf("%s\n", arg2);
    if (arg2) (*jenv)->ReleaseStringUTFChars(jenv, path, (const char *)arg2);
    return;
 }