...
private Map<String, Object> stopwords = null;

@Override
public void setup(Context context) {
    Configuration conf = context.getConfiguration();
    //hardcoded or set it in the jobrunner class and retrieve via this key
    String location = conf.get("job.stopwords.path");
    if (location != null) {
        BufferedReader br = null;
        try {
            FileSystem fs = FileSystem.get(conf);
            Path path = new Path(location);
            if (fs.exists(path)) {
                stopwords = new HashMap<String, Object>();
                FSDataInputStream fis = fs.open(path);
                br = new BufferedReader(new InputStreamReader(fis));
                String line = null;
                while ((line = br.readLine()) != null && line.trim().length() > 0) {
                    stopwords.put(line, null);
                }
            }
        }
        catch (IOException e) {
            //handle
        } 
        finally {
            IOUtils.closeQuietly(br);
        }
    }
}
...