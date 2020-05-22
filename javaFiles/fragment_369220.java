String[] tempCrfFC = crfFC;                //crfFC is a String[] itself
for(int i = 0; i < crfFC.length; i++) {
    String[] crfTok = tempCrfFC[i].split("\\s");
    if(crfTok.length == 40) {
        String[] parts = crfTok[39].split("/");
        if (parts[0].equals("O")) {
            Double v = Double.parseDouble(parts[1]);
            if (v <= d && (i == 0 || prevTagged != i-1)) {
                cfTok[39] = "A";    //<-------
                System.out.println("val: " + cfTok[39]);
                tempCrfFC[i] = join(cfTok);
                System.out.println("tempCrfFC: " + tempCrfFC[i]);
                prevTagged = i;
            }
         }
    }
}