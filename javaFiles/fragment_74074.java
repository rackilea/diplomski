jclass cls2 = env->FindClass("MyTest");
    JNINativeMethod methods[] { { "doMonitor", "()V", (void *)&doMonitorCPP } };
    if(env->RegisterNatives(cls2, methods, 1) < 0)
    {
        if(env->ExceptionOccurred())
            cerr << " OOOOOPS: exception when registreing natives" << endl; 
        else
            cerr << " ERROR: problem when registreing naives" << endl;
    }