// let's erase the sysout "Two"
    int lineNumberToReplace = 10;
    // Access the code attribute
    CodeAttribute codeAttribute = method.getMethodInfo().getCodeAttribute();

    // Access the LineNumberAttribute
    LineNumberAttribute lineNumberAttribute = (LineNumberAttribute)      codeAttribute.getAttribute(LineNumberAttribute.tag);

    // Index in bytecode array where the instruction starts
    int startPc = lineNumberAttribute.toStartPc(lineNumberToReplace);

    // Index in the bytecode array where the following instruction starts
    int endPc = lineNumberAttribute.toStartPc(lineNumberToReplace+1);

    System.out.println("Modifying from " + startPc + " to " + endPc);

    // Let's now get the bytecode array
    byte[] code = codeAttribute.getCode();
    for (int i = startPc; i < endPc; i++) {
      // change byte to a no operation code
       code[i] = CodeAttribute.NOP;
    }