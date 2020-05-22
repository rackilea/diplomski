public class InstructionCallsEvaluator {
public String evaluate(Instruction1 instruction, Call1 call){
    return this.evaluate( (Instruction) instruction, (Call) call);
}

public String evaluate(Instruction1 instruction, Call2 call){
    return this.evaluate( (Instruction) instruction, (Call) call);
}

public String evaluate(Instruction1 instruction, Call3 call){
    return this.evaluate( (Instruction) instruction, (Call) call);
}

public String evaluate(Instruction2 instruction, Call1 call){
    return this.evaluate( (Instruction) instruction, (Call) call);
}

public String evaluate(Instruction2 instruction, Call2 call){
    return this.evaluate( (Instruction) instruction, (Call) call);
}

public String evaluate(Instruction2 instruction, Call3 call){
    return this.evaluate( (Instruction) instruction, (Call) call);
}

public String evaluate(Instruction3 instruction, Call1 call){
    return this.evaluate( (Instruction) instruction, (Call) call);
}

public String evaluate(Instruction3 instruction, Call2 call){
    return this.evaluate( (Instruction) instruction, (Call) call);
}

public String evaluate(Instruction3 instruction, Call3 call){
    return this.evaluate( (Instruction) instruction, (Call) call);
}

private String evaluate(Instruction instruction, Call call){
    return instruction.evaluate() + "  " + call.evaluate();
}
}