public String getRequestProperty (String key) {
        // don't return headers containing security sensitive information
        if (key != null) {
            for (int i=0; i < EXCLUDE_HEADERS.length; i++) {
                if (key.equalsIgnoreCase(EXCLUDE_HEADERS[i])) {
                    return null;
                }
            }
        }
        return requests.findValue(key);
    }