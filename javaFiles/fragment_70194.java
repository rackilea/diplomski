public void decideProtocol(URL url) throws IOException {
            if ("https".equals(url.getProtocol())) { 
                // It is https
            } else if ("http".equals(url.getProtocol())) {
                // It is http
            }
    }