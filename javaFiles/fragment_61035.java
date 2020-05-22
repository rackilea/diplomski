Job job = Job.getInstance(conf, "befriended numbers");

// Set this property to Zero to run map-only job 
job.setNumReduceTasks(0);

job.setJarByClass(FriendlyNumbers.class);
job.setMapperClass(FriendlyNumberMapper.class);
job.setCombinerClass(IntSumReducer.class);
job.setMapOutputKeyClass(IntWritable.class);
job.setMapOutputValueClass(NumberCouple.class);
job.setOutputKeyClass(IntWritable.class);
job.setOutputValueClass(IntWritable.class);