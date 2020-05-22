%inline %{
object *new_object() {
  // SWIG will assume that it doesn't own this
  return new object;
}
%}