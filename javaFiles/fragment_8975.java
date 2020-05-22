while (counter > 0) {
   // reuse the conf reference with a fresh object
   conf = new Configuration();
   // set the depth into the configuration
   conf.set("recursion.depth", depth + "");
   job = new Job(conf);
   job.setJobName("Graph explorer " + depth);

   job.setMapperClass(ExplorationMapper.class);
   job.setReducerClass(ExplorationReducer.class);
   job.setJarByClass(ExplorationMapper.class);
   // always work on the path of the previous depth
   in = new Path("files/graph-exploration/depth_" + (depth - 1) + "/");
   out = new Path("files/graph-exploration/depth_" + depth);

   SequenceFileInputFormat.addInputPath(job, in);
   // delete the outputpath if already exists
   if (fs.exists(out))
    fs.delete(out, true);

   SequenceFileOutputFormat.setOutputPath(job, out);
   job.setInputFormatClass(SequenceFileInputFormat.class);
   job.setOutputFormatClass(SequenceFileOutputFormat.class);
   job.setOutputKeyClass(LongWritable.class);
   job.setOutputValueClass(VertexWritable.class);
   // wait for completion and update the counter
   job.waitForCompletion(true);
   depth++;
   counter = job.getCounters().findCounter(ExplorationReducer.UpdateCounter.UPDATED)
     .getValue();
}