public void open_File(){
        FileReader reader = null;
        try {
            reader = new FileReader("file\path\");
            //do something here
        } catch (IOException e) {
            //do something clever with the exception
        } finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    //do something clever with the exception
                }
            }
            System.out.println("--- File Process Ended ---");
        }
    }