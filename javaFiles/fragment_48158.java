for (int count = 0; count <= 100; count++){
    gamerReport = Scan.nextLine();

    if (gamerReport.equalsIgnoreCase("quit")) {
        System.out.println("You have quit!");
        break;
    }
    splitUpReport = gamerReport.split(":");

    gameNames[count] = splitUpReport[0];
    highScores[count] = Integer.parseInt(splitUpReport[1].trim() );
    minutesPlayed[count] = Integer.parseInt(splitUpReport[2].trim());
}