@Override
    public void addCommand(Command cmd) {
        if (cmd.getLabel().equals("Edit_Cell")){
           removeCommand(sample1); // with all the previously added commands
        }
        super.addCommand(cmd);
        if (cmd.getLabel().equals("Edit_Cell")){
          addCommand(sample1); // again with all your previously added commands
        }
    }