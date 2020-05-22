String ipAddress = "192.168.1.10";
    String[] addrArray = addr.split("\\.");

    long ipDecimal = 0;

    for (int i = 0; i < addrArray.length; i++) {

        int power = 3 - i;
        ipDecimal += ((Integer.parseInt(addrArray[i]) % 256 * Math.pow(256, power)));
    }

    System.out.println(ipDecimal);