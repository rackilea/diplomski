jstring str;
JNIEnv *env;
jclass clazz;
jfieldID fid;

// initialize str and env here ...

clazz = (*env)->FindClass(env, "my/package/MyClass");
fid = (*env)->GetStaticFieldID(env, clazz , "myField", "Ljava/lang/String;");
(*env)->SetStaticObjectField(env, clazz, fid, str);