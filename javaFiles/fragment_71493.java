JNIEXPORT jboolean JNICALL Java_com_foobar_showFilePropertiesDialogImpl 
  (JNIEnv *env, jobject obj, jlong hwnd, jstring fileName) 
{ 
    /* Get the name of the file. */ 
    const wchar_t *pszFile = (wchar_t *)env->GetStringChars(fileName, NULL); 
    if (pszFile==NULL) { /* Exception occurred */ 
        return JNI_FALSE; 
    } 

    int iErr = (int) ShellExecuteW((HWND)hwnd, L"properties", pszFile, NULL, NULL, SW_SHOWNORMAL);
    env->ReleaseStringChars(fileName, (const jchar *)pszFile); 

    /*
    wchar_t msg[36];
    if (iErr > 32)
        wsprintfW(msg, L"ShellExecute successful!"); 
    else 
        wsprintfW(msg, L"ShellExecute failed: %d", iErr); 
    MessageBoxW((HWND)hwnd, pszFile, msg, MB_OK); 
    */

    return JNI_TRUE; 
}