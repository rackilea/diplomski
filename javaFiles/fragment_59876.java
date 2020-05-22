%include <enums.swg>
%javaconst(1);

enum Type;
%typemap(jstype) int type "$typemap(jstype,enum Type)"
%typemap(javain) int type "$typemap(javain,enum Type)"

%include "header.h"

enum Type { TEXT=VRTTXT_TEXT,
            INTEGER=VRTTXT_INTEGER,
            DOUBLE=VRTTXT_DOUBLE,
            NONE=VRTTXT_NULL };