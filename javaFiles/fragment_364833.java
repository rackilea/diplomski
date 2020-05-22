extern "C" DLL_PUBLIC jbyteArray Java_com_ngochoang_playerdemo_AudioNativeLib_navProcessBytes(JNIEnv *env, jobject thiz, jbyteArray data, jint size)
{
    LOGV("JNI call soundtouch.navProcessBytes");
    int bufferSize = size*5;
    SAMPLETYPE sampleBuffer[bufferSize];
    pSoundTouch.putSamples((SAMPLETYPE*)data, size);
    TotalNSamples = pSoundTouch.receiveSamples(sampleBuffer, bufferSize);
    jbyteArray ret = env->NewByteArray(bufferSize);
    env->SetByteArrayRegion(ret, 0, bufferSize, (jbyte *)sampleBuffer);
    LOGV("JNI call soundtouch.navProcessBytes END");
    return ret;
}