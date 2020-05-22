public void method(){
        try {
            File file = new File("D:/projects/tFile.txt") ;
            file.createNewFile();
            FileOutputStream fout = new FileOutputStream(file);
            String s = "IPL is very entertaining tournament";
            byte []b = s.getBytes();
            fout.write(b);;
            fout.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }