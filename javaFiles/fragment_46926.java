try (ZipInputStream is = new ZipInputStream(Zippy.class.getResourceAsStream("file.zip"))) {
            ZipEntry entry;
            while ((entry = is.getNextEntry()) != null) {
                if (!entry.isDirectory()) {
                    // do your logic here (get the entry name)
                }                
                is.closeEntry();
        }
    }