File gpxfile = new File(File address, "filename.txt");

    BufferedWriter bW;

    try {
        bW = new BufferedWriter(new FileWriter(gpxfile));
        bW.write("file text");
        bW.newLine();
        bW.flush();
        bW.close();
    } catch (IOException e) {
        e.printStackTrace();
    }