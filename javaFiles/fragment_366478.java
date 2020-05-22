We can access an executing tasklet from jobRegistry 

    JobExecution jobExecution = findExecutionById(executionId);
try {
Job job = jobRegistry.getJob(jobExecution.getJobInstance().getJobName());
if (job instanceof StepLocator) {
// can only process as StepLocator is the only way to get the step object
                    // get the current stepExecution
for (StepExecution stepExecution : jobExecution.getStepExecutions()) {
if (stepExecution.getStatus().isRunning()) {
try {
 // have the step execution that's running -> need to 'stop' it
 Step step = ((StepLocator) job).getStep(stepExecution.getStepName());
 if (step instanceof TaskletStep) {

                        //Implement your logic here         }
                                }
                            } catch (NoSuchStepException e) {
                                logger.warn("Step not found", e);
                                throw new WorkflowServiceException("Step not found", e);
                            }
                        }
                    }
                }
            } catch (NoSuchJobException e) {
                logger.warn("Cannot find Job object in the job registry. StoppableTasklet#stop() will not be called", e);
                throw new WorkflowServiceException(
                        "Cannot find Job object in the job registry. StoppableTasklet#stop() will not be called", e);
            }

            return true;
        }