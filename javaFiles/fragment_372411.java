%module test

%{
#include <stdint.h>
%}

typedef struct {
} uint8_t;

%inline %{
  uint8_t *getData() {
    static uint8_t d[5];
    return d;
  }
%}