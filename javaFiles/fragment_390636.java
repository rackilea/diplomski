public static void main(String... agv){
    StringBuilder a = new StringBuilder("A");
    StringBuilder b = new StringBuilder("B");
    StringBuilder alsoA = a;
    swap(a, b);
    System.out.println(a); // B
    System.out.println(b); // A
    System.out.println(alsoA); //B
}