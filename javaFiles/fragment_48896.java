for(int i = 0; i < subNetWorks; i++) {
        System.out.print("Subnet " + i + " Net Address:" +
                Arrays.toString(ipAddr) + " to ");
        nextAddr(ipAddr);
        System.out.println(Arrays.toString(ipAddr));
        increment(ipAddr);
    }