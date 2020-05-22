//...
job1.setOutputKeyClass(Text.class);
job1.setOutputValueClass(MyArrayWritable.class);
job1.setInputFormatClass(WholeFileInputFormat.class);
job1.setOutputFormatClass(SequenceFileOutputFormat.class);

FileInputFormat.addInputPath(job1, new Path(args[2]));
SequenceFileOutputFormat.setOutputPath(job1, TEMP_PATH);
//...
job2.setInputFormatClass(SequenceFileInputFormat.class);
SequenceFileInputFormat.addInputPath(job2, TEMP_PATH);
FileOutputFormat.setOutputPath(job2, new Path(args[3]));