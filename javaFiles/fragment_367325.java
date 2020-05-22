JNIEXPORT jobject JNICALL Java_com_rmsdk_wrapper_RMServices_getBookmarkNew(
    JNIEnv *env, jobject thiso) {
   jclass cls = g_jniEnv->FindClass("br/com/iba/model/Annotation");

   jobject obj = g_jniEnv->AllocObject(cls);

   jmethodID meth1 = g_jniEnv->GetMethodID(cls, "setBookmark1", "(Ljava/lang/String;)V");
   jmethodID meth2 = g_jniEnv->GetMethodID(cls, "setPage", "(I)V");

   jstring jAssetName = g_jniEnv->NewStringUTF("Bookmark qualquer");

   g_jniEnv->CallObjectMethod(obj, meth1, jAssetName);
   g_jniEnv->CallObjectMethod(obj, meth2, 2);

   return obj;
};