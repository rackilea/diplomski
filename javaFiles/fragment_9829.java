static string jniErrors;

static jint JNICALL my_vfprintf(FILE *fp, const char *format, va_list args)
{
    char buf[1024];
    vsnprintf(buf, sizeof(buf), format, args);
    jniErrors += buf;
    return 0;
}

...

JavaVMOption options[1];
options[0].optionString = "vfprintf";
options[0].extraInfo = my_vfprintf;

JavaVMInitArgs vm_args;
memset(&vm_args, 0, sizeof(vm_args));
vm_args.nOptions = 1;
vm_args.options = options;
vm_args.version = JNI_VERSION_1_4;
vm_args.ignoreUnrecognized = JNI_FALSE;

JNIEnv env;
JavaVM jvm;

jint res = JNI_CreateJavaVM(&jvm, (void**)&env, &vm_args);

if (res != JNI_OK)
    setError(jniErrors);

jniErrors.clear();