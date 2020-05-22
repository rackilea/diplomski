File folder = new File("/path/to/my/folder");
    File[] listOfFiles = folder.listFiles();
    for (int i = 0; i < listOfFiles.length; i++) {
        if (listOfFiles[i].isFile()) {
            System.out.println(org.apache.commons.codec.binary.Hex.encodeHex(listOfFiles[i].toURI().getPath().getBytes()));
        }
    }