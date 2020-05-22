String s1 = "hhhh";
String s2 = "aaaa";

for (int i=0; i<(Math.max(s1.length(), s2.length())); i++){
    if(i < s1.length()){
        System.out.print(s1.charAt(i));
    }
    if(i < s2.length()){
        System.out.print(s2.charAt(i));
    }
}