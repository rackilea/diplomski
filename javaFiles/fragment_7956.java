public class Main {

public static void main(String[] args) {
    ArrayList<Instruction> instructions = getInstructions();
    ArrayList<Call> calls = getCalls();
    InstructionHandler handler = new InstructionHandler();

    for(Instruction instrct : instructions)
        for(Call call : calls)
            System.out.println(handler.evaluate(instrct, call));
}

private static ArrayList<Instruction> getInstructions(){
    ArrayList<Instruction> instructions = new ArrayList<>();
    instructions.add(new Instruction1("Instruction 1"));
    instructions.add(new Instruction2("Instruction 2"));
    instructions.add(new Instruction3("Instruction 3"));
    return instructions;
}

private static ArrayList<Call> getCalls(){
    ArrayList<Call> calls = new ArrayList<>();
    calls.add(new Call1("Call 1"));
    calls.add(new Call2("Call 2"));
    calls.add(new Call3("Call 3"));
    return calls;
}