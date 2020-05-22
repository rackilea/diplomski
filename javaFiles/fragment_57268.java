class MyClass implements Comparable<MyClass>{
    private int index;
    private int value;

    public MyClass(int i, int v){
       this.index = i;
       this.value = v;
    }

    @Override
    public String toString(){
        return "Index: "+index+" Value: "+value;
    }

    @Override
    public int compareTo(MyClass m) {
        return value - m.value;
    }
}