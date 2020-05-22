// JavaVM instance stored after JNI_OnLoad is called
JavaVM* javaVM = NULL;

// Since the class loader will not work with getJNIEnv(),
// you can store classes in GlobalRefs.
static jclass my_class_class;

/**
 * Load the JNIEnv and store the JavaVM instance for ater calls to getJNIEnv().
 *
 * @param jvm      The Java VM
 * @param reserved Reserved pointer
 *
 * @return         The supported version of JNI.
 */
JNIEXPORT jint JNICALL
JNI_OnLoad(
        JavaVM* jvm,
        void* reserved
) {
    javaVM = jvm;

    // Here we load the classes since getJNIEnv() does 
    // not work with the class loader from other threads
    JNIEnv* env = getJNIEnv();
    my_class_class = (*env)->NewGlobalRef(env, (*env)->FindClass(env, "com/my/java/package/MyClass"));

    // Return the supported JNI version.
    return JNI_VERSION_1_6;
}

/**
 * Retrieve an instance of JNIEnv to use across threads.
 *
 * Note that the class loader will not work with this instance (unsure why).
 *
 * @return a JNIEnv instance
 */
JNIEnv* getJNIEnv() {
    JNIEnv *env;

    // If the current thread is not attached to the VM, 
    // sets *env to NULL, and returns JNI_EDETACHED.
    //
    // If the specified version is not supported, sets *env to NULL, 
    // and returns JNI_EVERSION.
    //
    // Otherwise, sets *env to the appropriate interface, and returns JNI_OK.
    int status = (*javaVM)->GetEnv(javaVM, (void**)&env, JNI_VERSION_1_6);

    // Check if the JVM is not currently attached to the
    // calling thread, and if so attempt to attach it.
    if (status == JNI_EDETACHED) {
        // Attaches the current thread to a Java VM.
        // Returns a JNI interface pointer in the JNIEnv argument.
        status = (*javaVM)->AttachCurrentThread(javaVM, &env, NULL);
    }

    // If the result of GetEnv was JNI_EVERSION,
    // we want to abort.
    assert(status != JNI_EVERSION);

    // Return the ENV if we have one
    return env;
}

void handleData(uint8_t *data, size_t len) {
    JNIEnv* env = getJNIEnv();

    // ... call jni function using env and my_class_class ...
}