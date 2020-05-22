@Component
Class Someclass{
  ...............
     @Autowired
     private JobLauncher jobLauncher;
     @Autowired
     private Job job;  

     public void someFunction(){
       jobLauncher.run(job, new JobParameters());  
   }
}