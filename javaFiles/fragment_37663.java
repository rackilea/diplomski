JNIEXPORT void JNICALL Java_Main_foo(JNIEnv *env, jclass clazz, jfloatArray input)
{
    float* array = env->GetFloatArrayElements(input, NULL);
    jsize len = env->GetArrayLength(input);
    std::vector<float> img (array, array+len );
    // assuming foo will not alter img
    env->ReleaseFloatArrayElements(input, array, JNI_ABORT);
    foo(img);
}