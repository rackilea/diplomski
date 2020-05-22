public void sumAndMultiplyAndReference
    (@WebParam(name = "firstnumber", mode = WebParam.Mode.IN)int a,
     @WebParam(name = "firstnumber", mode = WebParam.Mode.IN)int b,
     @WebParam(name = "referencenumber", mode = WebParam.Mode.IN)int c
     @WebParam(name = "sum", mode = WebParam.Mode.OUT) Holder<Integer> sum,
     @WebParam(name = "multiply", mode = WebParam.Mode.OUT) Holder<Integer> multiply,
     @WebParam(name = "referencenumber", mode = WebParam.Mode.OUT) Holder<Integer> referencenumber){
    sum.value = a + b;
    multiply.value = a * b;
    referencenumber.value = c;
}