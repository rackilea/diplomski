boolean exists = new File("myFile").exists();
        FileOutputStream fos = new FileOutputStream("myFile", true);
        ObjectOutputStream oos = exists ? 
            new ObjectOutputStream(fos) {
                protected void writeStreamHeader() throws IOException {
                    reset();
                }
            }:new ObjectOutputStream(fos);