public void change(AtomicBoolean x, AtomicBoolean y, StringBuffer s) {
    x.set(true);
    y.set(true);
    s.append("vinay");
}

public static void main(String a[]) {
    AtomicBoolean x = new AtomicBoolean(false);
    Boolean y =  = new AtomicBoolean(false);
    change(x, y);
    System.out.println(x.get() + ", " + y.get()); // will print true true
}