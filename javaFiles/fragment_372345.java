public static void recurse(String prev, String next) {
    if (next.length() == 0) 
        System.out.println(prev);
    else {
        recurse(prev + next.charAt(0), next.substring(1));
        recurse(prev + "." + next.charAt(0), next.substring(1));
    }    
}