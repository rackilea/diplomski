void get_data()
{       
    int len = 0;
    char* value = NULL;
    /*Consider j_class, and j_methodid are already initialized*/
    jbyteArray j_value = (*env)->CallStaticObjectMethod(env, j_class, j_methodid);

    if(j_value != NULL)
    {
        len = (*env)->GetArrayLength(env, j_value);
        value = (*env)->GetByteArrayElements(env, j_value, NULL);
    }

    /*later on release the resource*/
    (*env)->ReleaseByteArrayElements(env, j_value, value, 0);
}