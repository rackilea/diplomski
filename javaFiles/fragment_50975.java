@Override
public void execute(JobExecutionContext context ) throws JobExecutionException {


    final String triggerName = context.getTrigger().getKey().getName();
    if (TRIGGER_NAME_1.equals(triggerName)) {
         // do work ...
    } 

    // other cases...
}