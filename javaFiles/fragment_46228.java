public static void main(String[] args) {

Set<String> set = new HashSet<String>();
String Str = "Abc";
String Str1 = "abc";
set.add("Abc");
if(!Str.equalsIgnoreCase("abc")) {
    set.add("abc");
}

System.out.println("Size---"+set.size());
System.out.println(set);

}