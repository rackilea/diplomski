il.append(InstructionConstants.ICONST_1);
il.append(factory.createNewArray(Type.getType(Class.class), 1));
il.append(InstructionConstants.DUP);
il.append(InstructionConstants.ICONST_0);
il.append(new LDC(constantPoolGen.addClass(Type.getType(String.class))));
il.append(InstructionConstants.AASTORE);