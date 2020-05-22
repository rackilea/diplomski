public <T extends MyArrayClass> void invokeMethod(String arrKey, HashMap<String,T>
        arrays) {
    T my2dArray = arrays.get(arrKey);
    method(my2dArray);
    :
    :
}