finally {
        if (connectionStream != null) {
            try {
                connectionStream.close();
            } catch (Exception ignore) {
                // Nothing to do
            }
        }
    }