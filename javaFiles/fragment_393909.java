public static class TokenizerMapper extends Mapper<Object, Text, Text, IntWritable>{

                private final static IntWritable ONE = new IntWritable(1);
                private Text word = new Text();


                public void map(Object key, Text value, Context context) throws IOException, InterruptedException, JsonParseException {

                           String title;
                           String id;
                           String cat;
                           String line;
                           String valueLine;
                           Details details = null;

                           line = value.toString();

                           // json object
                           Gson gsoObj = new Gson();
                           details = gsoObj.fromJson(line, Details.class);

                           // values
                           id = details.id;
                           cat = details.category;
                           title = details.title;


                           String final_ = id + " " +  cat + " " + title;

                           final_ = final_.replaceAll("[!?,:()1-9]", "");

                           // valueLine  = 1 business Tulsa Web Design

                           valueLine = final_;

                           StringTokenizer itr = new StringTokenizer(valueLine);
                           String IndexAndCategory = "";

                           IndexAndCategory += itr.nextToken() + " ";
                           IndexAndCategory += itr.nextToken() + " ";


                           while(itr.hasMoreTokens()) {

                            word.set(IndexAndCategory + itr.nextToken());
                            context.write(word, ONE);
                            }

                }

        private class Details {

                        protected String id = "";
                        protected String title = "";
                        protected String category = "";
                }

        }