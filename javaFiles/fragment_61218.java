buffer = new byte[1024];
            bufferedInputStream = new BufferedInputStream(inputStream);
            byteArrayOutputStream = new ByteArrayOutputStream();
            while( (readCount = bufferedInputStream.read(buffer)) > 0) {
                byteArrayOutputStream.write(buffer, 0, readCount);
            }
            returnFile = new DataHandler(byteArrayOutputStream.toByteArray(), "application/octet-stream");