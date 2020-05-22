public static void main(String args[]) {
        Hashtable<String, InetAddress> fileLocation = new Hashtable<String, InetAddress>();
        InetAddress addr;
        try {
            addr = InetAddress.getByName("127.0.0.1");
            fileLocation.put("ABD_9158", addr); // IPAdress is of InetAddress type
            InetAddress n = fileLocation.get("ABD_9158");
            System.out.println(n);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }