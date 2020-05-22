// Convert the character representing a direction, into a cardinal direction.
private static String getDirection(char direction) {
  if (direction == 'N' || direction == 'n') {
    return "North";
  } else if (direction == 'S' || direction == 's') {
    return "South";
  } else if (direction == 'E' || direction == 'e') {
    return "East";
  } else if (direction == 'W' || direction == 'w') {
    return "West";
  }
  return "Unknown";
}

public static void main(String[] args)
    throws InterruptedException {
  // Construct a scanner.
  Scanner scanner = new Scanner(System.in);

  // The output message format.
  String fmt = "Start facing %s.Turn %s degrees towards %s.";
  // Loop forever.
  for (;;) {
    // Print directions.
    System.out.println("Compass Directions");
    System.out.println("==================");
    System.out.println("Input a compass direction "
        + "(E.g. S45E):");
    // Check that System.in hasn't been closed.
    if (!scanner.hasNextLine()) {
      break;
    }
    // Get input.
    String line = scanner.nextLine();
    String start = getDirection(line.charAt(0));
    String end = getDirection(line.charAt(line
        .length() - 1));
    String msg = String.format(fmt, start,
        line.substring(1, line.length() - 1), end);
    System.out.println(msg);
  }
}