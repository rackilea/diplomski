void foo() {
    { // Freestanding block for scope, though not really needed as `foo` has
      // nothing else in it
        char[] a = foo;       // T[] #a = Expression;
        for (int i = 0; i < a.length; i++) {
            char foo = a[i];  // {VariableModifier} TargetType Identifier = #a[#i];
        }
    }
}