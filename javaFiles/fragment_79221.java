@Bean
public Job myJob() {

   List<Step> steps = new ArrayList<>();
   steps.add(processStep1);
   steps.add(processStep2);

   return jobBuilderFactory.get("yourJobName")               
        .start(createParallelFlow(steps));                
        .end()
        .build();
    }