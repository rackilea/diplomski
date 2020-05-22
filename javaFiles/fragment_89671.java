private class IntWrap{
    int value;

    public IntWrap(int v){ this.value=v; }
}

public static void swapInPlace(IntWrap a, IntWrap b){
    a.value = a.value + b.value;
    b.value = a.value - b.value;
    a.value = a.value - b.value;
}

public static void main(String[] args) {
    IntWrap a = new IntWrap(12);
    IntWrap b = new IntWrap(7);
    swapInPlace(a, b);
    System.out.println("a: " + a.value + " b: " + b.value);

}