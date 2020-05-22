{

JNIEXPORT jbyteArray JNICALL Java_org_alok_jni_AlokJNI_setByteArray
  (JNIEnv * env, jclass this1, jbyteArray ba, jint len) {
memcpy(my_char_array, ba, len);

}