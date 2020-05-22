FileInputStream fileInputStream = null;

        try {
            new FileInputStream("absoluteFilename");

            byte[] buffer = new byte[MAX_SIZE];
            int bufferIndex = 0;
            while (fileInputStream.available() > 0) {
                buffer[bufferIndex++] = (byte) fileInputStream.read();
            }
            byte[] fileContent = new byte[bufferIndex];
            System.arraycopy(buffer,0,fileContent,0,bufferIndex);

            URL serverUrl = new URL(url);
            URLConnection connection = serverURL.openConnection();
            connection.setConnectTimeout(60000);
            connection.getOutputStream().write(fileContent);

        } catch (Exception fatal) {
            //proper handling??
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception ignored) {}
            }
        }