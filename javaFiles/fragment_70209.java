void callJavaMethod( JNIEnv *env, jobject obj )
{
     jclass    cl;
     jmethodID id;
     jstring   js1;
     jstring   js2;
     jobject   byteArray;

     /* Im looking for byte[] javaMethod( String s1, String s2 ) */
     cl = (*env)->GetObjectClass( env, obj );
     id = (*env)->GetMethodID( env, cl, "javaMethod", "(Ljava/lang/String;Ljava/lang/String;)[B" );

     /* and now it's called */
     js1 = (*env)->NewStringUTF(env, "Hello");
     js2 = (*env)->NewStringUTF(env, "Java");

     byteArray = (*env)->CallObjectMethod( env, obj, js1, js2 );
     /* for other return types there are other CallxxxMethod() functions */

     ...
}