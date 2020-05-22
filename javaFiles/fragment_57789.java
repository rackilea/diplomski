if ("yes".compareToIgnoreCase(gluTen)==0)
    System.out.println(cookieName + " sorry i cant eat it.");
else
    System.out.println(cookieName + " okay to eat");



System.out.println("C1: " + ("yes".compareToIgnoreCase(peanutButter)==0) +" C2: "+ ("yes".compareToIgnoreCase(chocolate)==0) + "C3: " + ("no".compareToIgnoreCase(gluTen)==0));
System.out.println("C1 OR C2 AND C3" + ("yes".compareToIgnoreCase(peanutButter)==0 || "yes".compareToIgnoreCase(chocolate)==0 && "no".compareToIgnoreCase(gluTen)==0));
System.out.println("(C1 OR C2) AND C3" + (("yes".compareToIgnoreCase(peanutButter)==0 || "yes".compareToIgnoreCase(chocolate)==0) && "no".compareToIgnoreCase(gluTen)==0));