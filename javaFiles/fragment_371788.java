void Java_Tester_func
(JNIEnv *env, jobject obj) {
  jclass cls = (*env)->GetObjectClass(env,obj);
  jmethodID mid = (*env)->GetMethodID(env,cls,"printInteger","(I)V");
  jvalue a1,*arr;
  a1.i = 2;
  arr = &a1;
  (*env)->CallVoidMethodA(env,obj,mid,arr);
 }