JNIEXPORT jobject JNICALL Java_graphicanalyzer_ImageFeedOpenCV_getFrame
  (JNIEnv * env, jobject jThis, jobject camera)
{
    //...

    IplImage *frame = cvQueryFrame(pCaptureDevice);

    jobject byteBuf = env->NewDirectByteBuffer(frame->imageData, frame->imageSize);

    return byteBuf;
}