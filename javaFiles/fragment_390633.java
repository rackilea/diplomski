void swap(String a, String b) {
    String c = b;
    b = a;
    a = c;
}

void main() {
    String a = "A";
    String b = "B";
    swap(a, b);
    System.out.println(a); // A
    System.out.println(b); // B
}