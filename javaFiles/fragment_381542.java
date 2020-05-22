public static String pad(String s){
    String[] p = s.split("\\.");
    if (2 == p.length){
        return String.format("%02d.%s", Integer.parseInt(p[0]), p[1]);
    }
    return String.format("%02d", Integer.parseInt(p[0]));
}