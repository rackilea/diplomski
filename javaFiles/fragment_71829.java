InputStream is = MainClass.class.getClassLoader().getResourceAsStream(file location with zip file name);
        ZipInputStream zis = new ZipInputStream(is);
        ZipEntry ze = zis.getNextEntry();
        Scanner sc = new Scanner(zis);

        String[] wordsArray;
        while (sc.hasNextLine())
        {
           ....
        }