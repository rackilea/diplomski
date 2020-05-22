try {
        File file=null;
        fileStream = new FileInputStream(file=new File(filePath));
        data = new byte[(int)file.length()];
        fileStream.read(data,0,data.length);
        for (int X : data){
            System.out.print((char)X);
        }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }catch (IOException e) {
        e.printStackTrace();
    }