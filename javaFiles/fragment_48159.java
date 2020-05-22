// ignore the for loop
gamerReport = Scan.nextLine();

if (gamerReport.equalsIgnoreCase("quit")) {
    System.out.println("You have quit!");
    return;
}
splitUpReport = gamerReport.split(":");