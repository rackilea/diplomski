public int run(String[] args) throws Exception {
 Configuration c=new Configuration();
 String[] files=new GenericOptionsParser(c,args).getRemainingArgs();
 Path p1=new Path(files[0]);
 Path p2=new Path(files[1]);
 Path p3=new Path(files[2]);
 FileSystem fs = FileSystem.get(c);
 if(fs.exists(p3)){
  fs.delete(p3, true);
  }
 Job job = new Job(c,"Multiple Job");
 job.setJarByClass(MultipleFiles.class);
 MultipleInputs.addInputPath(job, p1, TextInputFormat.class, MultipleMap1.class);
 MultipleInputs.addInputPath(job,p2, TextInputFormat.class, MultipleMap2.class);
 job.setReducerClass(MultipleReducer.class);
 .
 .
}