File f = new File("test.jks");
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(null, null); // you have to initialize it

        //keyStore.set...args // add what you want

        try (FileOutputStream fout = new FileOutputStream(f)) {
            keyStore.store(fout, "changeit".toCharArray());
        }