jclass ent_clazz = env->FindClass("com/your/package/MyEntity");
if (!ent_clazz) return NULL;

// Get the IDs of the constructor and the _myEntityType field
jmethodID ent_init = env->GetMethodID(ent_clazz, "<init>", "()V");
jfieldID fid = env->GetFieldID(ent_clazz, "_myEntityType", "Ljava/lang/String;");
if (!ent_init || !fid) return NULL;

// Create a Java MyEntity instance
jobject result = env->NewObject(ent_clazz, ent_init);
if (!result || env->ExceptionCheck() != JNI_FALSE) {
    env->ExceptionClear();
    return NULL;
}

// entity is your C MyEntity instance
jstring jstr = env->NewStringUTF(entity._myEntityType);
if (!jstr || env->ExceptionCheck() != JNI_FALSE) {
    env->ExceptionClear();
    return NULL;
}

// Set the String field
env->SetObjectField(result, fid, jstr);

return result;