public class RegexIncludePathFilter extends Configured implements PathFilter {
    private String date;
    private FileSystem fs;

    public boolean accept(Path path) {
        try {
            if (fs.isDirectory(path)) {
                return true;
            }
        } catch (IOException e) {}
        return path.toString().endsWith(date);
    }

    public void setConf(Configuration conf) {
        if (null != conf) {
            this.date = conf.get("date");
            try {
                this.fs = FileSystem.get(conf);
            } catch (IOException e) {}
        }
    }
}