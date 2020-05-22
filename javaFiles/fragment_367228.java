BufferedReader in = BufferedReader(new InputStreamReader(
            pubIp.openStream()));
    try {
            String pub = in.readLine();
    } finally {
        in.close();
    }