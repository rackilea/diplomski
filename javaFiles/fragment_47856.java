%module test

%{
#include "test.h"
%}

%include <carrays.i>
%array_class(unsigned char,ByteArr);

%include "test.h"

// Emit Java code to automatically load the shared library
%pragma(java) jniclasscode=%{
  static {
    try {
        System.loadLibrary("test");
    } catch (UnsatisfiedLinkError e) {
      System.err.println("Native code library failed to load. \n" + e);
      System.exit(1);
    }
  }
%}