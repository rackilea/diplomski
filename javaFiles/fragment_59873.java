%ignore text_file
%include "header.h"
%extend gaiaTextReader {
  void setTextFile(const char *fn) {
    $self->text_file = fopen(fn, "r");
  }
}