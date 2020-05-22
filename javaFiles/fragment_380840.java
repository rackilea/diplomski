FileOutputStream os = null;
        try {
         os = new FileOutputStream(filePath);
        } catch (FileNotFoundException e) {
         e.printStackTrace();
        }