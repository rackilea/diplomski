public void addCurrentList() throws Exception{

            String pathToAppFolder = getExternalFilesDir(null).getAbsolutePath();
            String filePath = pathToAppFolder +File.seperator + "list.ser";
            try {
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filePath));
                os.writeObject(list);
                os.close();
            }
            catch (Exception e) {
                System.out.println("");
            }
        }