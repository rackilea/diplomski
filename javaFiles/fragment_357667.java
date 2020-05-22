interface Visitor<T> {
  T visit(T arg, DropDown answer);
  T visit(T arg, MultiChoice answer);
  T visit(T arg, SingleChoice answer);
  ...
}