JNIEXPORT jboolean JNICALL Java_MyJavaApplication_writeValue(JNIEnv* env, jobject obj, jbyteArray someJbyteArray)
{
    jsize len = env->GetArrayLength(someJbyteArray);
    jbyte* body = env->GetByteArrayElements(someJbyteArray, 0);
    unsigned char* someUnsignedChar = new unsigned char[len];
    for (jint i = 0; i < len; i++)
    {
        someUnsignedChar[i] = (unsigned char)body[i];
    }

    bool result = (gcnew MyCSharpLibrary())->writeValue((const unsigned char*)someUnsignedChar);

    env->ReleaseByteArrayElements(someJbyteArray, body, 0);
    return (jboolean)result;
}