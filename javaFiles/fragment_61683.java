%javamethodmodifiers objectArray::setitem "protected";
%rename  objectArray::setitem setitemImpl;

%typemap(javacode) objectArray %{
  public void setitem(int i, object o) {
    o.disown();
    setitemImpl(i, o);
  }
%}