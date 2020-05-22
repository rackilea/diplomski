BufferedWriter writer = null;
    try {
        GZIPOutputStream zip = new GZIPOutputStream(
            new FileOutputStream(new File("tmp.zip")));

        writer = new BufferedWriter(
            new OutputStreamWriter(zip, "UTF-8"));

        String[] data = new String[] { "this", "is", "some", 
            "data", "in", "a", "list" };

        for (String line : data) {
            writer.append(line);
            writer.newLine();
        }
    } finally {         
        if (writer != null)
            writer.close();
    }