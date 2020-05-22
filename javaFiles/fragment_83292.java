Configuration config = new Configuration();
    FileSystem fs = FileSystem.get(config);
    String s = fs.getHomeDirectory()+"/chart.png";
    Path path = new Path(s);
    FSDataOutputStream out = fs.create(path);
    out.write(bytes);
    out.close();