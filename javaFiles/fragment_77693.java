// create wrapper object
jclass wrapper = env->FindClass("IntWrapper");
jmethodID constructor = env->GetMethodID(wrapper, "<init>", "(I)V");
jobject wrapperObject = env->NewObject(wrapper, constructor, val);

// print value before increment
jmethodID getInt = env->GetMethodID(wrapper, "getInt", "()I");
jint ret = env->CallIntMethod(wrapperObject, getInt);
printf("Wrapper value: %d\n", ret);

// call inc3
jmethodID inc3 = env->GetStaticMethodID(cls, "inc3", "(LIntWrapper;)V");
env->CallStaticVoidMethod(cls, inc3, wrapperObject);

// print result
ret = env->CallIntMethod(wrapperObject, getInt);
printf("Wrapper value after increment: %d\n", ret);