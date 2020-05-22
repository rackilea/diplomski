public static boolean endOther(String a, String b) {
    if(a == null || b == null) {
      return false;
    }    
    String lowerA = a.toLowerCase();
    String lowerB = b.toLowerCase();
    return lowerA.endsWith(lowerB) || lowerB.endsWith(lowerA);
}