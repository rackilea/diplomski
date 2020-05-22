// exc is the exception object
exc = envLoc->ExceptionOccurred();

...

// exccls is the exception CLASS
jclass exccls = envLoc->GetObjectClass(exc);
jmethodID getCodeMeth = envLoc->GetMethodID(exccls, "getCode", "()I");

...

// CallIntMethod(jobject instance, jmethodID method)
jint jcode = envLoc->CallIntMethod(exccls, getCodeMeth);
// exccls is the CLASS, not the object
// so correct would be:
jint jcode = envLoc->CallIntMethod(exc, getCodeMeth);