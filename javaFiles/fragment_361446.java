String TESTSTRING = "<div style='color: blue; border: thin solid red;'>YO!</div>";

    File root = Environment.getExternalStorageDirectory();
    if (root.canWrite()){
        File gpxfile = new File(root, "samplefile.html");
        FileWriter gpxwriter = new FileWriter(gpxfile, true);
        BufferedWriter out = new BufferedWriter(gpxwriter);
        out.write(TESTSTRING);
        out.close();
    }