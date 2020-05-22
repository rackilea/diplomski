void method_a(Integer arg, Object... otherArgs) {
    method_b(arg, otherArgs);   // ok
}
void method_b(Object arg, Object... otherArgs) {
    method_a(arg, otherArgs);   // error
}