public static boolean check(String oldop, String newop){
    if(oldop == null || oldop.equals("=")){
        return true;
    }

    return (oldop.equals("+") || oldop.equals("-")) && (newop.equals("/") || newop.equals("*"));
}