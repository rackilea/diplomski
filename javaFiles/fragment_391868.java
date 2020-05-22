extern "C" JNIEXPORT void Java_com_example_myapp_MyOnClickListener_OnClick(
        JNIEnv *env,
        jclass clazz,
        jlong nativePeer) {
    auto f = reinterpret_cast<std::function<void(void)>*>(nativePeer);
    (*f)();
}

extern "C" JNIEXPORT void Java_com_example_myapp_MyOnClickListener_Release(
        JNIEnv *env,
        jclass clazz,
        jlong nativePeer) {
    auto f = reinterpret_cast<std::function<void(void)>*>(nativePeer);
    delete f;
}

...

// Setting the OnClickListener

// We allocate this object with `new` since we need it to remain alive
// until the Java code no longer needs it. It is the responsibility of
// the Java code to ensure that the memory gets freed.
auto callback = new std::function<void(void)>([] {
    __android_log_print(ANDROID_LOG_WARN, "MyOnClickListener", "Hello from native onClick!");
});

jclass listener_clazz = env->FindClass("com/example/myapp/MyOnClickListener");
jmethodID new_listener = env->GetMethodID(listener_clazz, "<init>", "(J)V");
jobject listener = env->NewObject(listener_clazz, new_listener, callback);

jmethodID set_onclicklistener = env->GetMethodID(button_clazz, "setOnClickListener", "(Landroid/view/View$OnClickListener;)V");

env->CallVoidMethod(button, set_onclicklistener, listener);