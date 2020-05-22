public class StepFlowController implements JobExecutionDecider{

    @Override
    public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
        FlowExecutionStatus status = null;
        try {
            ExecutionContext executionContext = jobExecution.getExecutionContext();

            Object validationStatus = executionContext.get("VALIDATESTATUS");
            if (!Utils.isNullOrEmpty(validationStatus)) {
                if (validationStatus.equals("HEADERFAIL")) {
                    status = new FlowExecutionStatus("HEADER");;
                } else if (validationStatus.equals("TAILERFAIL")) {
                    status = new FlowExecutionStatus("TRAILER");
                } else if (validationStatus.equals("DATACOUNTFAIL")) {
                    status = new FlowExecutionStatus("DATA");
                }else {
                    status = new FlowExecutionStatus("COMPLETE");
                }
            }else {
                status = new FlowExecutionStatus("COMPLETE");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return status;
    }

}