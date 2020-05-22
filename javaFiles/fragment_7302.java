JNIEXPORT myJavaObj JNICALL Java_cls_getObj
(JNIEnv *env, jobject obj)
{
jclass myClass;

//Find your class
myClass = (*env)->FindClass(env, "()LMyJavaClass;");

jmethodID cons = env->GetMethodID(myClass, "<init>", 
                              "(V)V"); 
jobject obj = env->NewObject(myClass, cons);

//Return the object.
return obj;
}