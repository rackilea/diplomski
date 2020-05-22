jclass clazz = (*env)->GetObjectClass(env,obj);
jfieldID infoExtra = (*env)->GetFieldID(env, clazz, "InfoExtra", "[LDetail;");
jobjectArray extras = (*env)->GetObjectField(env, clazz,infoExtra);

for (int i=0; i< ((*env)->GetArrayLength(env,extras)); i++) {
    jobject element = (*env)->GetObjectArrayElement(env,extras,i);
    //Do something with it, then release it
    (*env)->DeleteLocalRef(env,element);
}

//Don't forget to release the array as well
(*env)->DeleteLocalRef(env,extras);