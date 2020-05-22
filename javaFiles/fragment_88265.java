class CommandDispatcher{
 private List<ICommand> commands = new ArrayList<ICommand>();
 public CommandDispatcher(){
 }
 private ICommand currentCommand = null;
 public void setCommand(ICommand cmd){
   currentCommand  = cmd;
   cmd.execute();
   commands.add(cmd);
 }
 public void undoAll(){
    for(ICommand cmd : commands){cmd.undo();}
}
 public void undo(){
 commands.remove(commands.size()-1);
 currentCommand = commands.get(commands.size()-1)
}
public void redo(){
if(null!=currentCommand) currentCommand.redo();
}