%module test

%include <std_string.i>

%{
#include "test.h"
%}

%inline %{
  struct Method2Result {
    bool b;
    std::string s1;
    std::string s2;
  };

  Method2Result method2(const std::string& in1, const std::string& in2) {
    Method2Result ret;
    ret.b = method2(in1,in2,ret.s1,ret.s2);
    return ret;
  }
%}

// Optional: don't wrap the original form of method2 at all:
%ignore method2;

%include "test.h"