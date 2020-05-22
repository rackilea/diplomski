String operate(BiFunction<Value,Value,Boolean> function, TypeOfParam1 param1, TypeOfParam2 param2) {
    val1 = some computations on param1
    val2 = some other computations on param2
    Boolean value = function.apply(val1,val2);
    return value ? "Yes" : "No";
}