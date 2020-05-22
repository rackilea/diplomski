try {
        File file = new File("C:\\Users\\Zsbappa\\Pictures\\test\\output.txt");
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();

        String str = new String(data, "UTF-8");

        String lines[] = str.split("\\r?\\n");
        for (String line : lines) {
            System.out.println(line);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }