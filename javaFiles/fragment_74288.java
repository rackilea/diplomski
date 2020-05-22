int WrapperFunc(int *id)
{
      jint retval;
      //marshalling an int* to a m_SizeClass boogy-woogy.
      ...
      g_env->ExceptionClear();
      retval = g_env->CallIntMethod(g_getSizeIface, g_method, 
                                    /*marshalled m_SizeClass*/);
      if(g_env->ExceptionOccurred()){
          //panic! Light fires! The British are coming!!!
          ...
          g_env->ExceptionClear();
      }     
      return rvalue;
}