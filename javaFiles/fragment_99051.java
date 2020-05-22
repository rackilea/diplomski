PipelineOptions myOptions = ...
myOptions.setRunner(DataflowPipelineRunner.class);
Pipeline p = Pipeline.create(myOptions);

// Build up your pipeline and run it.
p.apply(...)
p.run();

// At this point in time, the files which were staged by the 
// DataflowPipelineRunner will have been populated into the
// DataflowPipelineWorkerPoolOptions#getFilesToStage
List<String> stagedFiles = myOptions.as(DataflowPipelineWorkerPoolOptions.class).getFilesToStage();
for (String stagedFile : stagedFiles) {
  System.out.println(stagedFile);
}