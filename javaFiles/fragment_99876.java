public static char getChar ()
{
    String s = getString();
    if (s.length() >= 1){
        return s.charAt(0);
    }else{
        return '\n';
    }
}