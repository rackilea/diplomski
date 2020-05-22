%module test

%inline %{
struct Foo {};
%}

%javamethodmodifiers Foo::hashCode %{@Override
  public%};

%extend Foo {
  int hashCode() {
    return 0;
  }
};