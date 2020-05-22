private byte[] getGzip(byte[] body) throws IOException {

        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream zipStream = new GZIPOutputStream(byteStream);
            try {
                zipStream.write(body);
            } finally {
                zipStream.close();
            }
        } finally {
            byteStream.close();
        }

        byte[] compressedData = byteStream.toByteArray();
        return compressedData;

    }