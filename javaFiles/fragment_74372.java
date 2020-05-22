FileWriter fileWriter = null;
        try {
            String content = document.html()
            File newTextFile = new File("C:/test/test.txt");
            fileWriter = new FileWriter(newTextFile);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(WriteStringToFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(WriteStringToFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }