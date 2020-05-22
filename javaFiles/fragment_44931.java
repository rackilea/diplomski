%module test

%{
#include "test.h"
%}

// Provide 'instance' class for strong typing (instead of void* semantics)
%rename(Instance) instance;
%nodefaultctor;
struct instance {};
typedef instance * instance_t;

// Don't leak (not that we have a destructor yet, but...)
%newobject new_instance;

// Change new_instance to return instance of Instance

%typemap(jstype) int new_instance "$typemap(jstype,instance_t)";
%typemap(jni) int new_instance "$typemap(jni,instance_t)";
%typemap(jtype) int new_instance "$typemap(jtype,instance_t)";

// Hide the instance_t argument and use a temporary instead under the hood
%typemap(in,numinputs=0) instance_t * ($1_basetype tmp) %{
  $1 = &tmp;
%}
// After the call copy the result back
%typemap(argout) instance_t * %{
  *($1_ltype)&$result = *$1;
%}
// Inside Java construct the proxy with the correct long pointer
%typemap(javaout) int new_instance {
  return new $typemap(jstype,int new_instance)($jnicall, $owner);
}

// Some error handling
%javaexception("Exception") new_instance {
  $action
  if (!result) {
    // JNI code to raise exception, untested in this form
    jclass clazz = JCALL1(FindClass, jenv, "Exception");
    JCALL2(ThrowNew, jenv, clazz, "Failure creating thing");
    return $null;
  }
}

%include "test.h"