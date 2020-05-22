extern double obj(double *, int *);
extern int init(); 
static JavaVM *jvm;

JNIEnv* create_vm(JavaVM **jvm)
{
    JNIEnv* env;
    JavaVMInitArgs args;
    JavaVMOption options;
    args.version = JNI_VERSION_1_6;
    args.nOptions = 1;
    options.optionString = "-Djava.class.path=./";
    args.options = &options;
    args.ignoreUnrecognized = 0;
    int rv;
    rv = JNI_CreateJavaVM(jvm, (void**)&env, &args);
    if (rv < 0 || !env)
        printf("Unable to Launch JVM %d\n",rv);
    else
        printf("Launched JVM successfully\n");
    return env;
}

int init() 
{
    JNIEnv *env_init;
    env_init = create_vm(&jvm);
    if(env_init == NULL)
      return 1;
}

double obj(double *ptr, int *c_size)
{
    JNIEnv *env;
    jdouble *dptr;
    jdoubleArray newArray;
    jint size;
    double result;

    size = *c_size;
    dptr = (double *)ptr;

    jint rs = (*jvm)->AttachCurrentThread(jvm, (void **)&env, NULL);
    newArray = (*env)->NewDoubleArray(env, size);

    (*env)->SetDoubleArrayRegion(env, newArray, 0, size, (const jdouble*)dptr); 

    jclass objFuncJ_class;
    jmethodID main_method;
    jmethodID evaluate_method;

    objFuncJ_class = (*env)->FindClass(env, "objFuncJ"); 
    evaluate_method = (*env)->GetStaticMethodID(env, objFuncJ_class, "evaluate", "([D)D"); 
    result = (*env)->CallStaticDoubleMethod(env, objFuncJ_class, evaluate_method, newArray);

    printf("Result = %f\n",result);
    return result;
}