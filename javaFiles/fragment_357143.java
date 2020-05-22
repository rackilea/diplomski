// Each possible direction - with Up/Down added to show extendability.
public enum Dir {
  North,
  South,
  East,
  West,
  Up,
  Down;
}

class Room {
  // The doors.
  EnumSet doors = EnumSet.noneOf(Dir.class);

  // Many other possible constructors.
  public Room ( Dir ... doors) {
    this.doors.addAll(Arrays.asList(doors));
  }

  public boolean doorExists (Dir dir) {
    return doors.contains(dir);
  }
}