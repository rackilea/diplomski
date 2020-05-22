JNIEXPORT jlong JNICALL Java_JavaClass_createNativeInstance
    ( JNIEnv*   p_jenv
    , jobject   p_jthis
    , params )
{
    // Convert params from Java types to C++ types if required
    return (jlong) new CppClass( converted_params );
}

JNIEXPORT void JNICALL Java_JavaClass_destroyNativeInstance
    ( JNIEnv*   p_jenv
    , jobject   p_jthis
    , jlong     p_native_ptr )
{
    if( p_native_ptr )
        delete (CppClass*)p_native_ptr;
}

JNIEXPORT jstring JNICALL Java_JavaClass_nativeMethod
    ( JNIEnv*   p_jenv
    , jobject   p_jthis
    , jlong     p_native_ptr
    , params
    )
{
    // Convert params from Java types to C++ types if required
    std::string cpp_result = ((CppClass*)p_native_ptr)->cppMethod( converted_params );
    jstring java_result = p_jenv->NewStringUTF( cppResult.c_str() );
    return java_result;
    // NOTE: std::string destructor will free cpp_result memory
}