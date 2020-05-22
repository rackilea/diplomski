for (Enumeration<? extends ZipEntry> e = zipFile.entries(); e.hasMoreElements();) {
    ZipEntry entryIn = e.nextElement();
    if (entryIn.getName().contains("sample.xml")) {
        zos.putNextEntry(new ZipEntry("sample.xml"));
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(zipFile.getInputStream(entryIn),
                                                                                      StandardCharsets.UTF_8))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("Input")) {
                    System.out.println("edit count");
                    line = line.replace("Input", "output")

                }
                line += System.lineSeparator(); // Add newline back.
                byte[] buf = line.getBytes(StandardCharsets.UTF_8);
                zos.write(buf);
            }
        }
     zos.closeEntry();
    }
}