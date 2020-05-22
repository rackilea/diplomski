File file = new File("D:/FolderName/");

        // Getting all files in directory
        File[] files = file.listFiles();

        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }

        // Reading a particular file

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader("D:/FolderName/testfile.xml"));
            String line = null;

            while(true)
            {
                line = reader.readLine();
                if(line == null)
                    break;

                System.out.println(line);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            if(reader != null)
            {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }