JNIEXPORT void JNICALL
Java_com_example_hellojni_HelloJni_test(JNIEnv *env, jobject instance, jstring s_) {
  const char *s = (*env)->GetStringUTFChars(env, s_, 0);

  // TODO

  (*env)->ReleaseStringUTFChars(env, s_, s);
}