String piStr = "3.14159";
        Double pi=1.0;
        int s=1;
        double j=3.0; 
        String lcl = "";
        String upToNCharacters = "";
        while (true)
        {
            if (s % 2 == 0)
                pi = pi + (1/j);
            else
                pi = pi - (1/j);

            s = s + 1;
            j=j+2;

            lcl = "" + 4 * pi;
            upToNCharacters = lcl.substring(0, Math.min(lcl.length(), 7));
            if (upToNCharacters.equals(piStr)) {
                break;
            }
        }
        System.out.println(upToNCharacters);
        System.out.println("after " + s);