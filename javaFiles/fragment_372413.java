%module test

%{
#include <stdint.h>
%}

%include <stdint.i>
%include <carrays.i>

%array_class(uint8_t, U8_Array);

%typemap(jstype) uint8_t *getData "U8_Array"
%typemap(javaout) uint8_t *getData {
  return new $typemap(jstype,uint8_t *getData)($jnicall,$owner);
}

%inline %{
  uint8_t *getData() {
    static uint8_t d[5];
    return d;
  }
%}