%module TestModule
%{
#include "test.h"
%}

%include "std_string.i" // for std::string typemaps

// Allow C++ exceptions to be handled in Java
%typemap(throws, throws="java.io.IOException") CustomException {
  jclass excep = jenv->FindClass("java/io/IOException");
  if (excep)
    jenv->ThrowNew(excep, $1.what());
  return $null;
}

// Force the CustomException Java class to extend java.lang.Exception
%typemap(javabase) CustomException "java.lang.Exception";

// Override getMessage()
%typemap(javacode) CustomException %{
  public String getMessage() {
    return what();
  }
%}

%include "test.h"