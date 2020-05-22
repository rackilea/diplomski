/**
 * Invalidate WebFlow history. For use in action-state, where the transition element is not able
 * to specify to invalidate history.
 */
public static void invalidateHistory() {
    RequestContext context = RequestContextHolder.getRequestContext();

    synchronized(context.getFlowExecutionContext()) {
        DefaultFlowExecutionRepository r =
                (DefaultFlowExecutionRepository)
                ((FlowExecutorImpl)
                    context.getActiveFlow().
                    getApplicationContext().
                    getBean(FlowExecutor.class)).getExecutionRepository();
        r.removeAllFlowExecutionSnapshots((FlowExecution)context.getFlowExecutionContext());
    }
}