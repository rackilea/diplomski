%ignore toUtf8;
%include "header.h"

%extend gaiaTextReader {
  void setToUtf8(const char *from) {
    $self->toUtf8 = iconv_open("tocode", from);
  }
}