public class InstructionHandler {

public String evaluate(Instruction instruction, Call call) {
    try {
        return  useEvaluator(InstructionCallsEvaluator.class, instruction, call);
    } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | 
             InvocationTargetException | NoSuchMethodException ex) {
        Logger.getLogger(InstructionHandler.class.getName()).log(Level.SEVERE, null, ex);
    }
    return "Something went wrong when calling Evaluator";
}


private String useEvaluator(Class<InstructionCallsEvaluator> instructionCallsEvalutor, Instruction instruction, Call call) 
                    throws InstantiationException, IllegalAccessException, IllegalArgumentException, 
                    InvocationTargetException, NoSuchMethodException {    
    Class[] methodParameterTypes = new Class[]{instruction.getClass(), call.getClass()};
    Object instance = instructionCallsEvalutor.newInstance();
    Method method = instructionCallsEvalutor.getDeclaredMethod("evaluate", methodParameterTypes);
    return  method.invoke(instance, instruction, call).toString();
}