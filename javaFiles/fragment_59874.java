%ignore columns;    
%include "header.h"

%extend gaiaTextReader {
  struct vrttxt_column_header *getColumn(int i) {
    return $self->columns + i;
  }

  void setColumn(struct vrttxt_column_header *c, int i) {
    $self->columns[i] = *c;
  }
}