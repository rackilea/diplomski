%module test

%{
#include <stdint.h>

void foo(void *in) {
  printf("%p, %d, %g\n", in, *(jint*)in, *(jdouble*)in);
}
%}

%typemap(in,numinputs=0) JNIEnv *env "$1 = jenv;"

%javamethodmodifiers arr2voidd "private";
%javamethodmodifiers arr2voidi "private";
%javamethodmodifiers freearrd "private";
%javamethodmodifiers freearri "private";
%inline %{
jlong arr2voidd(JNIEnv *env, jdoubleArray arr) {
  void *ptr = (*env)->GetDoubleArrayElements(env, arr, NULL);
  return (intptr_t)ptr;
}

void freearrd(JNIEnv *env, jdoubleArray arr, jlong map) {
  void *ptr = 0;
  ptr = *(void **)&map;
  (*env)->ReleaseDoubleArrayElements(env, arr, ptr, JNI_ABORT);
}

jlong arr2voidi(JNIEnv *env, jintArray arr) {
  void *ptr = (*env)->GetIntArrayElements(env, arr, NULL);
  return (intptr_t)ptr;
}

void freearri(JNIEnv *env, jintArray arr, jlong map) {
  void *ptr = 0;
  ptr = *(void **)&map;
  (*env)->ReleaseIntArrayElements(env, arr, ptr, JNI_ABORT);
}
%}


%pragma(java) modulecode=%{
  private static long arrPtr(Object o) {
    if (o instanceof double[]) {
      return arr2voidd((double[])o);
    }
    else if (o instanceof int[]) {
      return arr2voidi((int[])o);
    }
    throw new IllegalArgumentException();
  }

  private static void freeArrPtr(Object o, long addr) {
    if (o instanceof double[]) {
      freearrd((double[])o, addr);
      return;
    }
    else if (o instanceof int[]) {
      freearri((int[])o, addr);
      return;
    }
    throw new IllegalArgumentException();
  }
%}

%typemap(jstype) void *arr "Object"
%typemap(javain,pre="    long tmp$javainput = arrPtr($javainput);",post="      freeArrPtr($javainput, tmp$javainput);") void *arr "tmp$javainput"

void foo(void *arr);