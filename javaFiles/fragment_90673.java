void OperateData(byte* data, int dataLength)
{
    JavaMethod* methodObj = getMethod(_T("OperateData"));
    if (!methodObj) return;
    JNIEnv* jniEnv = JvmManager::GetInstance()->GetJNIEnv();
    if (!jniEnv) return;
    jbyteArray jData = jniEnv->NewByteArray((jsize)dataLength);
    if (!jData) return;
    jniEnv->SetByteArrayRegion(jData, 0, (jsize)dataLength, (jbyte*)data);
    jobject jBuffer = jniEnv->CallObjectMethod(m_javaObject->getJObject(), methodObj->getJMethodID(), jData, (jint)dataLength);
    if (jBuffer) jniEnv->DeleteLocalRef(jBuffer);
    jniEnv->DeleteLocalRef(jData);
}