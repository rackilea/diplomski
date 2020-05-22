extern "C" jvoid Java_com_wrapper_NativeTagCallback_NativeCallback( JNIEnv* pEnv, jobject jCaller, jlong cppCallbackPtr, jint arg0, jstring arg1, jobject arg2 )
{
    MyCallback cppCallback = (MyCallback)cppCallbackPtr;
    const char* pCString = pEnv->GetStringUTFChars( arg1, 0);
    string arg1Str( pCString );
    pEnv->ReleaseStringUTFChars( arg1, pCString );

    set< string > arg2Set = ConvertJavaSetToCPPSet( arg2 );  // Perform your java to CPP set conversion here.

    cppCallbackPtr( (int)arg0, arg1Str, arg2Set );
}