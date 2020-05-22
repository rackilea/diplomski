public boolean endOther(String a, String b) {
        String x = a.toLowerCase();
        String y = b.toLowerCase();
        int xl = a.length();
        int yl = b.length();

        if(xl > yl && x.substring(xl-yl).equals(y)) return true;
        if(xl < yl && y.substring(yl-xl).equals(x)) return true;
        if(xl == yl && x.equals(y)) return true;
        else return false;
}