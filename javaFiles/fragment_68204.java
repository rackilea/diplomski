%module test

%{
#include "test.hh"
%}

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