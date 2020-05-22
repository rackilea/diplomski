String extension = ".xml"//or ".jpg" or anything
String filename = myfile+extension;
byte[] data = //the byte array which i got from server
File f = new File(givepathOfFile+filename );

        try {
            f.createNewFile();

            // write the bytes in file
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(data );
            fo.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }