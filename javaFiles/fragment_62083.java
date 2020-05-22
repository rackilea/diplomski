public void sumAndMultiplyAndReference
    (@WebParam(name = "firstnumber")int a,
     @WebParam(name = "firstnumber")int b,
     @WebParam(name = "referencenumber")int c
     @WebParam(name = "sum", mode = WebParam.Mode.OUT) Holder<Integer> sum,
     @WebParam(name = "multiply", mode = WebParam.Mode.OUT) Holder<Integer> multiply,
     @WebParam(name = "reference", mode = WebParam.Mode.OUT) Holder<Integer> reference){
    sum.value = a + b;
    multiply.value = a * b;
    reference.value = c;
}