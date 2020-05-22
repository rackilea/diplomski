public static void printAtFile(String filename, String header, String content[])
    {
        System.out.println("Start creating file "+filename);
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filename);
            writer.println(header);
            for(String u:content)
                writer.println(u);
            writer.close();
        } catch (Exception ex) {
            System.out.println("Error while writing at file "+filename);
        }
    }