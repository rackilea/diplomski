Configuration conf = new Configuration();
conf.set("mapreduce.input.keyvaluelinerecordreader.key.value.separator", ",");

Job job = new Job(conf);
job.setInputFormatClass(KeyValueTextInputFormat.class);
// next job set-up