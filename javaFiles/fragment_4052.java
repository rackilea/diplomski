public static String reduce(String str){
    if(str.equals(""))
        return "Empty String";
    if(str.length()<2)
        return str;
    if(str.charAt(0)==str.charAt(1))
        return reduce(str.substring(2));

    String rest = str.substring(1);
    String reducedRest = reduce(rest);

    if (rest.equals(reducedRest)) 
        return str;
    else 
        return reduce(str.charAt(0) + reducedRest);
}