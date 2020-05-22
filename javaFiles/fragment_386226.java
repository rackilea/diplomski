%module test 

%{
#include "test.h"
%}

%typemap(jstype) enum boolean "boolean"

%typemap(javaout) enum boolean {
  return $jnicall != 0;
}

%typemap(javain) enum boolean "$javainput?1:0"

%include "test.h"