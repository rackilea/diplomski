Register reg1 = new SimpleRegister(48911);
        Register reg2 = new SimpleRegister(23593);
        Register reg3 = new SimpleRegister(48911);
        Register reg4 = new SimpleRegister(23593);

        WriteMultipleRegistersRequest req = new WriteMultipleRegistersRequest(41200,new Register[]{reg1,reg2,reg3,reg4});
        WriteMultipleRegistersResponse res = new WriteMultipleRegistersResponse();