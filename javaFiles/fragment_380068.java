public void writeObject(Object serObj, File theFile) throws IOException {
        if(!theFile.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        try (FileOutputStream fileOut = new FileOutputStream(filepath + fileName);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
             objectOut.writeObject(serObj);
        }
    }