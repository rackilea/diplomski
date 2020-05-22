String hexString = "FF FF FF FF FF FF FF FF"; 
    String[] hexNumbers = hexString.split(" ");   //split the string
    int[] ints = new int[hexNumbers.length];      

    for(int i = 0; i<hexNumbers.length; i++) {
        ints[i] = Integer.parseInt(hexNumbers[i], 16);  //convert from hexString to int
    }

    for(int i = 0; i<ints.length; i++) {
        System.out.println(ints[i]);
    }