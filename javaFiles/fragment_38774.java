template <typename T>
static jint android_media_AudioTrack_writeArray(JNIEnv *env, jobject thiz,
                                            T javaAudioData,
                                            jint offsetInSamples, jint sizeInSamples,
                                            jint javaAudioFormat,
                                            jboolean isWriteBlocking) {