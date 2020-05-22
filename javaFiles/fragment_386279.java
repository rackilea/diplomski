void ReadJavaObject(JNIEnv * env,  jobject mainObjectJava)
{
    jclass cls = env->GetObjectClass(mainObjectJava);   
    jfieldID subObjectID = env->GetFieldID(cls, "subObject", "Lmy/package/name/SubObject;");
    jobject subObjectJava= env->GetObjectField(mainObjectJava, subObjectID);
}