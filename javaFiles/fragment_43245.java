%module test

%apply(char *STRING, size_t LENGTH) { (char *str, size_t len) };

%inline %{
void some_func(char *str, size_t len) {
}
%}