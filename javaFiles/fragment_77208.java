//Create a new configuration
Configuration conf = new Configuration();
//Set the work to be searched
conf.set("wordToSearch", "Tree");
//create the job
Job job = new Job(conf);