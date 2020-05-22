public static void main(String[] args) {
    int x = 25;
    Integer a = new Integer(x);
    Integer b = new Integer(x);
    System.out.println(a == b);     // false
    Integer c = Integer.valueOf(x);
    Integer d = Integer.valueOf(x);
    System.out.println(c == d);     // true
    Integer e = (Integer)x;
    Integer f = (Integer)x;
    System.out.println(e == f);     // true
}