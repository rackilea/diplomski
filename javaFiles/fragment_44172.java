<K> void method_a(K arg, Object... otherArgs) {
    this.<K>method_b(arg, otherArgs);   // ok
}
<K> void method_b(Object arg, Object... otherArgs) {
    this.<K>method_a(arg, otherArgs);   // error
}