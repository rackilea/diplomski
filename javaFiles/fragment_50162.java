private ReadCommand readCommand;

@Inject
public Controller(ReadCommand readCommand) {
    this.readCommand = readCommand;
    if(this.readCommand == null) {
        ...
    }
}