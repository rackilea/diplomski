void swap(StringBuilder a, StringBuilder b) {
    String a1 = a.toString();
    String b1 = b.toString();
    a.setLength(0);
    a.append(b1);
    b.setLength(0);
    b.append(a1);
}

void main(){
    StringBuilder a = new StringBuilder("A");
    StringBuilder b = new StringBuilder("B");
    swap(a, b);
    System.out.println(a); // B
    System.out.println(b); // A
}