Code code = new Code();
code.setA((byte) 'a');
code.setB((byte) 'b');
...
JNATest.printStruct(code.getPointer());
code.free();  // free the memory allocated in the constructor