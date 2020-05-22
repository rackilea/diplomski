try {
        test ();
    } catch (IOException ioe) {
        if(ioe instanceof SSLHandshakeException)
            throw ioe;
        System.out.println("I`m handling IO exception that is not an SSLHandshakeException");
    }