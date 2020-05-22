%module test

%{
#include "test.h"
%}

%include <cpointer.i>
// Have SWIG create a helper class for "pointer to pointer" type of handle
%pointer_class(instance_t, inst_ptr);
// Hide default version of new_instance
%javamethodmodifiers new_instance "private";

// Supply  Java version of new_instance now with useful method signature
%pragma(java) modulecode=%{
  public static SWIGTYPE_p_void new_instance(String name) {
    inst_ptr ptr = new inst_ptr();
    final int err = new_instance(name, ptr.cast());
    if (0!=err) {
      // throw or whatever
    }
    return ptr.value();
  }
%}

%include "test.h"