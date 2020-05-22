@Override
 public void setup(Context context) throws IOException, InterruptedException {
     conf = context.getConfiguration();
     caseSensitive = conf.getBoolean("wordcount.case.sensitive", true);
     if (conf.getBoolean("wordcount.skip.patterns", true)) {
         URI[] patternsURIs = Job.getInstance(conf).getCacheFiles();
         for (URI patternsURI : patternsURIs) {
             Path patternsPath = new Path(patternsURI.getPath());
             String patternsFileName = patternsPath.getName().toString();
             parseSkipFile(patternsFileName);
         }
     }
}