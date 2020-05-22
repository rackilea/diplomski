%typemap(in,numinputs=1) (const signed char *begin, const signed char *end) {
  $1 = JCALL2(GetByteArrayElements, jenv, $input, NULL);
  const size_t sz = JCALL1(GetArrayLength, jenv, $input);
  $2 = $1 + sz;
}

%typemap(freearg) (const signed char *begin, const signed char *end) {
  // Or use  0 instead of ABORT to keep changes if it was a copy
  JCALL3(ReleaseByteArrayElements, jenv, $input, $1, JNI_ABORT);
}

%typemap(jtype) (const signed char *begin, const signed char *end) "byte[]"
%typemap(jstype) (const signed char *begin, const signed char *end) "byte[]"
%typemap(jni) (const signed char *begin, const signed char *end) "jbyteArray"
%typemap(javain) (const signed char *begin, const signed char *end) "$javainput"