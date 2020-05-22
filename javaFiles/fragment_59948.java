public class Data { 
    private String value; 
    public void set(String value) { this.value = value; }
    public String get() { return this.value; }
}

public class ClassA {
    Data data = new Data();
    ClassA() { data.set("From ClassA"); }
}

public class ClassB {
    Data data;
    ClassB(Data data) { this.data = data; }
    public void print() {
      System.out.println(data.get());
    }
}

public static void main(String args []) {
    new ClassB(new ClassA().data).println();
}