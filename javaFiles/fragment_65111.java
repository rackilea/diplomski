@Pointcut("execution(* com.service.processes.communication.CommunicationProcess.*(..))")
private void communicationMethods() {}

@Pointcut("execution(@com.lib.annotation.Loggable * *.*(..))")
private void loggableMethods() {}

@Before("communicationMethods() && loggableMethods()")
public void logMethodCallWithParameters(JoinPoint joinPoint)
{
    if (joinPoint.getArgs().length == 0)
    {
        logEntryService.logDebug(LogEntrySource.SERVICE, LogEntryType.MESSAGING, "Method " + joinPoint.getTarget().getClass().getCanonicalName() 
            + "." + joinPoint.getSignature().getName() + " called with no argument", logger);
    }
    else
    {
        logEntryService.logDebug(LogEntrySource.SERVICE, LogEntryType.MESSAGING, "Method " + joinPoint.getTarget().getClass().getCanonicalName() 
            + "." + joinPoint.getSignature().getName() + " called with argument(s) " + getArgumentString(joinPoint.getArgs()), logger);
    }
}