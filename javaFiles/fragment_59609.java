byte[] zip(byte[] data, String filename) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ZipArchiveOutputStream zos = new ZipArchiveOutputStream(bos);

        ZipArchiveEntry entry = new ZipArchiveEntry(filename);
        entry.setSize(data.length);
        zos.putArchiveEntry(entry);
        zos.write(data);
        zos.closeArchiveEntry();

        zos.close();
        bos.close();

        return bos.toByteArray();       
   }