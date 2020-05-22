%module(directors=1) MyModule
%feature("director");         

%{
#include "mydll.h"
%}

%include "mydll.h"