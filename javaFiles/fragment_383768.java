extern "C" {
#if (CC_TARGET_PLATFORM == CC_PLATFORM_ANDROID)
    jint Java_org_reanix_bubbleshooter_BubbleShooter_jniPrintSomething(JNIEnv *env, jobject obj,jint val){
        return 0;
    }
#endif
}