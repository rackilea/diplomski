System.out.println("ITERATIONS: " + iterations);
System.out.println("LEN: " + stranica.length());
System.out.println("LAST 50 chars: "
        + stranica.substring(stranica.length() - 50, stranica
                .length()));

FileWriter fw = new FileWriter("/tmp/tmp-j2se.txt");
fw.write(stranica);
fw.close();