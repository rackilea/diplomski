int main()
{
    Jvm VM("C:/Users/Brandon/IdeaProjects/Eos/out/production/Eos/Bot.jar");

    jclass jMain = VM.GetENV()->FindClass("eos/Main");

    if (jMain != nullptr)
    {
        jmethodID mainMethod = env->GetStaticMethodID(jMain, "main", "([Ljava/lang/String;)V");
        jclass StringClass = env->FindClass("java/lang/String");
        jobjectArray Args = env->NewObjectArray(0, StringClass, 0);
        env->CallStaticVoidMethod(jMain, MainMethod, Args);
    }
}