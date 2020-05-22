//not sure what type your input is, in any case, convert it to a string (or byte array)
String str = "10110001";
for(int i = str.length()-1; i >= 0; i--){
    if(str.charAt(i) == '1')
        System.out.println("one");
    if(str.charAt(i) == '0')
        System.out.println("zero");
}