struct Foo { ... some member fields ... }
struct Bar { ... some member fields ... }
struct Baz { ... some member fields ... }

union Envelope {
  1: Foo foo
  2: Bar bar
  3: Baz baz
}