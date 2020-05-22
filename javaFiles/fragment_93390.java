/* get size of the array */
jsize len = (*env)->GetArrayLength(env, aChar);

/* get the body of array; it will be referecende by C pointer */
jchar *body = (*env)->GetCharArrayElements(env, aChar, 0);

jstring mystr =  (*env)->NewString(env, body, len);

/* release body when you decide it is no longer needed */
(*env)->ReleaseCharArrayElements(env, aChar, body, 0);

const unsigned char *theValue = (*env)->GetStringUTFChars(env,mystr, NULL);