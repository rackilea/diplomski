**Writing** : PrintWriter,Scanner,BufferedWriter etc to write to that file
**Reading** :FileReader,BufferReader,Scanner with these readers etc

String path = "G:"+File.separator+"Software"+File.separator+"Files";
    String fname= path+File.separator+"fileName.txt";
        File f = new File(path);
        File f1 = new File(fname);
        f.mkdirs() ;
        try {
            f1.createNewFile();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }