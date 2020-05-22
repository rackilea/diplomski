%module test 

%{
#include "test.h"
%}

%apply bool { enum boolean };

%include "test.h"