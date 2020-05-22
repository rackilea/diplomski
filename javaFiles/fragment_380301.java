String str = "JAVA";
System.out.println(str);
for(int i=1; i<str.length()-1; i++){
    System.out.print(str.charAt(i));
    for(int j=1; j<str.length()-1; j++){
        System.out.print(' ');
    }
    System.out.println(str.charAt(str.length()-1-i));
}
for(int i=0; i<str.length(); i++){
    System.out.print(str.charAt(str.length()-1-i));
}