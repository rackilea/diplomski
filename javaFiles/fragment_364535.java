EvaluationContext context = new EvaluationContext( null, new Object() )
context.addVariable( ISources.ACTIVE_PART_NAME, activePart );
context.addVariable( ISources.ACTIVE_CURRENT_SELECTION_NAME, selection );
// add whatever is used by the handler...

Map<String, String> parameters = new HashMap<>();
ExecutionEvent event = new ExecutionEvent( command, parameters, null, context );

command.executeWithChecks( event );