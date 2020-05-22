int programResult = 0;
try {
    programResult = Integer.parseInt(standardProgramResult);
} catch (NumberFormatException e) {
    System.err.println("programResult was not a number: " + programResult);
    // possibly ignore error, or terminate...
    // e.printStackTrace(); // prints the stack trace
    // throw e; // throws the error for someone else to handle
    // System.exit(1); // terminate indicating an error in execution
}
int numbProgram=0;
for (int output: output){
    numProgram += Math.abs(programResult - output)
}