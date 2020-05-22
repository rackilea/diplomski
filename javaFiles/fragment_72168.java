int len=new ControlFlow(m).basicBlocks().length;
        for(int i=0; i<len; ++i){
            Block thisbb=new ControlFlow(m).basicBlocks()[i]; //we have to re-evaluate the control flow every time we add new code
            CodeIterator itr=m.getMethodInfo().getCodeAttribute().iterator();

            int pos=thisbb.position();
            byte[] newCode=new byte[]{Bytecode.ALOAD, //loads the mse class
                                      mseCSindex, //my mse local variable
                                      Bytecode.ICONST_0, //the input to the virtual function
                                      Bytecode.INVOKEVIRTUAL, //execute the virtual function
                                      (byte) virtFunIndex>>8, //virtual function's address
                                      (byte) virtFunIndex && 0xFF};

            int n = itr.insertAt(pos, newCode);
        }