Pattern p = Pattern.compile("-?\\d+");
    Pattern p1 = Pattern.compile("[a-zA-Z]");

    Matcher m = p.matcher(mgrs);
    Matcher m1 = p1.matcher(mgrs);


    //initializing variables

    while (m.find()) {
    System.out.println(m.group());
    }//end while

while (m1.find()) {
    System.out.println(m1.group());
    }//end while