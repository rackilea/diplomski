String s = "BC+D*E-=";

    for (int i = 0; i < s.length(); i++) {
        char charAt2 = s.charAt(i);
        if (Character.isLetter(charAt2)) {
            System.out.println(charAt2 + "is a alphabet");
        }
    }