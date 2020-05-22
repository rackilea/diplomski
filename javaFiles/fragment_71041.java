void JNICALL Java_com_example_nativeopencvandroidtemplate_MainActivity_processFrame(JNIEnv *env, jobject instance, jlong matAddrGray) {
     Mat &mGr = *(Mat *) matAddrGray;

     // process Mat
     ...
}