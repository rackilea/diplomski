try {
        test ();
    } catch (SSLHandshakeException sslExc) {
        throw sslExc;
    } catch (IOException ioe) {
        System.out.println("I`m handling IO exception that is not an SSLHandshakeException");
    }