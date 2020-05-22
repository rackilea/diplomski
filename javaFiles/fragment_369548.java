void MyCpp::setTags(set<string> tags, MyCallback callback)
{
    extern __thread JNIEnv* gpEnv;

    // Get the setTags function.
    jclass      jWrapperClass                   = gpEnv->FindClass( "com/wrapper/cocoswrapper" ); // Insert the correct class name here.    
    jmethodID   jWrapperSetTag                  = gpEnv->GetStaticMethodID( jWrapperClass, "setTags", "(Landroid/content/Context;Ljava/util/Set;Lcom/wrapper/TagCallback)V;" );

    // Get the TagCallback related function
    jclass      jNativeTagCallbackClass         = gpEnv->FindClass( "com/wrapper/NativeTagCallback" );
    jclass      jNativeTagCallbackConstructor   = gpEnv->GetMethodID( jNativeTagCallbackClass, "<init>", "(J)V" );
    jobject     jNativeTagCallbackObject        = gpEnv->NewObject( jNativeTagCallbackClass, jNativeTagCallbackConstructor, (jlong)callback)

    // Make function call.
    gpEnv->CallStaticVoidMethod( jWrapperClass, jWrapperSetTag, jAndroidContext, tags.GetJNIObject(), jNativeTagCallbackObject );
}