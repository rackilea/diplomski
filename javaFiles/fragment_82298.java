String data="164/165/165"; //the hidden bells are there, generated via echo $'164\a/165\a/165' | pbcopy
System.out.println("length with hidden bells: "+data.length());

String elems [] = data.split("\\a/");
for(String e:elems) {
    System.out.println(e);
    System.out.println(e.length());
}