JNIEXPORT void JNICALL Java_ClassName_MyCPPFunction
     (JNIEnv *env, jint size, jobject getSizeInterface)
{
      jclass objclass = env->GetObjectClass(getSizeInterface);
      jmethodID method = env->GetMethodID(objclass, "GetSize", "(m_SizeClass)I");
      if(methodID == 0){
          std::cout << "could not get method id!" << std::endl;
          return;
      }
      g_method = method;
      g_getSizeIface = getSizeInterface;
      g_env = env
      MyCPPFunction(size, WrapperFunc);
}