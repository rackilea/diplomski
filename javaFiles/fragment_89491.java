public Torero deepCopy(Torero input){
    Torero copy = new Torero();
    copy.setValue(input.getValue());//.. copy primitives, deep copy objects again

    return copy;
}