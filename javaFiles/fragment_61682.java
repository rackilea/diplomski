%typemap(javacode) object %{
  object transfer() {
    swigCMemOwn = false;
    return this;
  }
%}