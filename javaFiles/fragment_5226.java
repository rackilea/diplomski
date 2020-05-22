String[] strings = {"X839WS21R4E877", "x83rws21b3e87a"};
for(String str : strings){
    str = str.toUpperCase();// to convert the string to UpperCase
    str = str.replaceAll("([A-Z0-9])([A-Z0-9]{3})([A-Z0-9]{4})([A-Z0-9]{2})([A-Z0-9]{3})([A-Z0-9])", 
            "$1-$2 $3 $4-$5 ($6)");

    System.out.println(str);
}