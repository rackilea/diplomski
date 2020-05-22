DataHandler dataHandler = attachment.getDataHandler();
        final byte[] data;
        try (InputStream inputStream = dataHandler.getInputStream()) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            final byte[] buffer = new byte[4096];
            for (int read = inputStream.read(buffer); read > 0; read = inputStream.read(buffer)) {
                outputStream.write(buffer, 0, read);
            }
            data = outputStream.toByteArray();
        }

        //todo write data to BLOB