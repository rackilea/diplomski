public void process(String filename) throws IOException {
    process(filename, new FileInputStream(new File(filename)));
}

private void process(String filename, InputStream inputStream) throws IOException {
    ZipInputStream zis = new ZipInputStream(inputStream);
    ZipEntry ze = null;

    while ((ze = zis.getNextEntry()) != null) {
        if (ze.isDirectory()) {
            continue;
        }

        System.out.println(ze.getName() + " " + ze.getSize());

        if (ze.getName().endsWith(".jar")) {
            long size = ze.getSize();

            byte[] b = new byte[(int) size];

            int rb = 0;
            int chunk = 0;
            while (((int) size - rb) > 0) {
                chunk = zis.read(b, rb, (int) size - rb);
                if (chunk == -1) {
                    break;
                }
                rb += chunk;
            }

            process(ze.getName(), new ByteArrayInputStream(b));
        }
    }
}