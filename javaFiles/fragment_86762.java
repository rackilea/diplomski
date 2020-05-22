private static void splitPrinter(String s) {
    StringBuilder sO = new StringBuilder();
    StringBuilder sE = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
        if (i%2==0) {
            sE.append(s.charAt(i));
        } else {
            sO.append(s.charAt(i));        
        }
    }
    sE.append(" ");
    sE.append(sO.toString());
    System.out.println(sE.toString());
}