try {
        Hints hints = new Hints();
        hints.getList();        // adds to the stack
        Stack s = hints.getStack();  // return the stack
        int stackSize = s.size();

        for (int i = 0; i < stackSize; i++) {

            System.out.println(s.pop());        // pop from the stack
        }
    } catch (IOException ex) {
        Logger.getLogger(JavaApplication18.class.getName()).log(Level.SEVERE, null, ex);
    }