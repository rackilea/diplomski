error: incompatible types: cannot infer type arguments for Test.C<>
    C<?> i = new C<>();
                  ^
    reason: inferred type does not conform to upper bound(s)
      inferred: Test.C<CAP#1>
      upper bound(s): Test.C<Test.C<CAP#1>>,Test.C<CAP#1>
  where CAP#1 is a fresh type-variable:
    CAP#1 extends Test.C<CAP#1> from capture of ?