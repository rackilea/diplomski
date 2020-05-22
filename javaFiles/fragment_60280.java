public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the hours: ");
    int hours = scanner.nextInt();
    System.out.print("Enter the minutes: ");
    int minutes = scanner.nextInt();
    System.out.print("Enter the seconds: ");
    int seconds = scanner.nextInt();
    if (seconds >= 0 && seconds <= 60) {
      minutes = minutes + 1; // why do you increment minutes here?
      if (minutes >= 60) {
        hours = hours + 1; // if minutes is 120, then you'd have to add 2 hours
        minutes = 00; // if minutes is 61, then you should not set minutes to 0
        if (hours >= 24) {
          hours = 00; // same here
        }
      }
    }
    System.out.println(seconds + ":" + minutes + ":" + hours);
}