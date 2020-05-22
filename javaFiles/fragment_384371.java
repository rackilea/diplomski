// The basic interface for all door commands
public interface DoorCommand {
    public void execute(Door door) throws CommandException;
}

// The Door class is the recipient for all commands
public class Door {
    private List<Command> history = new ArrayList<Command>();
    private int angle;
    private boolean locked;

    public void addCommandToHistory(Command command) {
        history.add(command);
    }

    // Getters and setters.
}

// The command to open the door
public class OpenDoor implements DoorCommand {
    public void execute(Door door) throws CommandException {
        door.addCommandToHistory(this);
        if (door.isLocked()) {
            throw new CommandException("Door is locked, cannot open");
        }
        if (door.getAngle() < 90) {
            door.setAngle(90);
        }
    }
}

// Another command, LockDoor
public class LockDoor implements DoorCommand {
    public void execute(Door door) throws CommandException {
        door.addCommandToHistory(this);
        door.setLocked(true);
    }
}