response.setContentLength(length);

        FileInputStream byteStream = new FileInputStream(file);
        BufferedInputStream bufStream = new BufferedInputStream(
                byteStream);
        ServletOutputStream responseOutputStream = response
                .getOutputStream();
        final int BLOCK_SIZE = Math.min(16*1024, length);
        byte[] data = new byte[BLOCK_SIZE];
        while (length > 0) {
            int nread = bufStream.read(data, 0, Math.max(length, block.length));
            if (nread <= 0) {
                // Something fishy happened, upload of other smaller version.
                break;
            }
            length -= nread;
            responseOutputStream.write(data, 0, nread);
        }
        bufStream.close();