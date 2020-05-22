FileSystem fs = FileSystem.get(context.getConfiguration());
for (URI p : files) {
    Path path = new Path(p.toString());
    FSDataInputStream fsin = fs.open(path);
    DataInputStream in = new DataInputStream(fsin);
    BufferedReader br = new BufferedReader(new InputStreamReader(in));

    //Use br

    br.close();
    in.close();
    fsin.close();           
}