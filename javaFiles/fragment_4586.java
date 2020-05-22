String sBefore = "2.03 445 ";

    String sAfter = sBefore.replaceAll("\\s+", "");//replace white space and tabs
    //String sAfter = sBefore.replace(' ', '');//replace white space only
    double i = 0;

    try {
        i = Double.parseDouble(sAfter);//parse to integer
    } catch (NumberFormatException nfe) {
        nfe.printStackTrace();
    }
    System.out.println(i);//2.03445