<K> void method_a(K arg, Object... otherArgs) {
    method_b(arg, otherArgs);   //ok L1
}
<K> void method_b(Object arg, Object... otherArgs) { // extract 1 arg from vararg
    method_a(arg, otherArgs);   //ok L2
}