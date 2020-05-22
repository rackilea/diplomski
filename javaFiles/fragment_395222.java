JNIEnv* env;
JavaVMInitArgs args;
JavaVMOption options[3];
args.version = JNI_VERSION_1_6;
args.nOptions = 3;
options[0].optionString = "-Djava.class.path=./";
options[1].optionString = "-Djava.class.path=<path_to_class>:<path_to_jars>";
options[2].optionString = "-Djava.class.path=<path_to_class>:<path_to_jars>";
args.options = options;
args.ignoreUnrecognized = 0;
int status;
status = JNI_CreateJavaVM(jvm, (void**)&env, &args);
if (status < 0 || !env)
    printf("Unable to Launch JVM %d\n",rv);
else
    printf("Launched JVM successfully\n");
return env;