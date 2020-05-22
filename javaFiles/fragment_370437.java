String a="LetterA";
String b="ALetterB";
int compare = a.compareTo(b);
if (compare < 0){
    System.out.println(a+" is before "+b);
}
else if (compare > 0) {
    System.out.println(b+" is before "+a);
}
else {
    System.out.println(b+" is same as "+a);
}