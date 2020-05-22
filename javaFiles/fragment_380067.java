public void writeObject(Object serObj, String fileName) throws 
    IOException {
        File theFile = new File(filepath + fileName);
        if(!theFile.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        try (FileOutputStream fileOut = new FileOutputStream(filepath + fileName);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
             objectOut.writeObject(serObj);
        }
    }