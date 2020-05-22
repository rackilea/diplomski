%module test 

%{
#include "test.h"
%}

%typemap(jstype) enum boolean "boolean"

%typemap(javacode) enum boolean %{
  public boolean toBoolean() {
    return this == TRUE;
  }
%}

%typemap(javaout) enum boolean {
  return $javaclassname.swigToEnum($jnicall).toBoolean();
}

%typemap(javain) enum boolean "($javainput?Boolean.TRUE:Boolean.FALSE).swigValue()"

%include "test.h"