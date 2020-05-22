JNIEXPORT jboolean JNICALL Java_com_stackoverflow_homework_MyApplication_setAppUserModelID(JNIEnv* env)
{
  LPCWSTR id = L"com.stackoverflow.homework.MyApplication";
  HRESULT hr = SetCurrentProcessExplicitAppUserModelID(id);

  return hr == S_OK;
}