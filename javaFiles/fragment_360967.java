QAndroidJniObject::callStaticMethod<void>("org/example/AndroidTest", "doSomething");

public static void doSomething()
{
}

jint value = QAndroidJniObject::callStaticMethod<jint>("org/example/AndroidTest", "doSomethingElse");

public static int doSomethingElse()
{
    return 1;
}