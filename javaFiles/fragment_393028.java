/* File : example.i */
%module encoder

%include <std_vector.i>

%{
#include "SubwordEncoder.h"
%}

%template(IntVector) std::vector<int>;
%template(CharVector) std::vector<char>;

/* Let's just grab the original header file here */
%include "SubwordEncoder.h"