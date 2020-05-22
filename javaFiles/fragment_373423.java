String DATADIR = "C:/Users/OneDrive/Desktop/";
        for (int i = 0; i <= 2; i++) {
            File tmpDir = new File(DATADIR+" myFile.csv");
            if (!tmpDir.exists() && !tmpDir.isDirectory()){ //checking file availability
                tmpDir.createNewFile(); //create new file
            }
            FileWriter writer = new FileWriter(DATADIR+ "myFile.csv", true); //as mentioned if not available then create new file so here always available file
            if (i==0){
               writer.write("This is my first line \n"); //writing first line
                     }
            else {
                writer.write(i+ "\n"); //then appends all other data.
            }
            writer.close();

        }