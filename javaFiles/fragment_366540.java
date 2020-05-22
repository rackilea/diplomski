Configuration configuration = new Configuration();
        // create a configuration object that provides access to various
        // configuration parameters
        Job job = new Job(configuration, "Wordcount-Vowels & Consonants");
        // create the job object and set job name as Wordcount-Vowels &
        // Consonants
        job.setJarByClass(WordCount.class);
        // set the main class
        job.setNumReduceTasks(2);
        // set the number of reduce tasks required
        job.setMapperClass(WordCountMapper.class);
        // set the map class for the job
        job.setCombinerClass(WordCountCombiner.class);
        // set the combiner class for the job
        job.setPartitionerClass(VowelConsonantPartitioner.class);
        // set the partitioner class for the job
        job.setReducerClass(WordCountReducer.class);
        // set the reduce class for the job
        job.setOutputKeyClass(Text.class);
        // set the output type of key (the word) expected from the job, Text
        // analogous to String
        job.setOutputValueClass(IntWritable.class);
        // set the output type of value (the count) expected from the job,
        // IntWritable analogous to int
        FileInputFormat.addInputPath(job, new Path(args[0]));
        // set the input directory for fetching the input files
        FileOutputFormat.setOutputPath(job, new Path(args[1]));