jthrowable e = env->ExceptionOccurred();
env->ExceptionClear(); // clears the exception; e seems to remain valid

jclass clazz = env->GetObjectClass(e);
jmethodID getMessage = env->GetMethodID(clazz,
                                        "getMessage",
                                        "()Ljava/lang/String;");
jstring message = (jstring)env->CallObjectMethod(e.get(), getMessage);
const char *mstr = env->GetStringUTFChars(message, NULL);
// do whatever with mstr
env->ReleaseStringUTFChars(message, mstr);
env->DeleteLocalRef(message);
env->DeleteLocalRef(clazz);
env->DeleteLocalRef(e);