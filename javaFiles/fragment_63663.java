int i = 0;
while(scan.hasNext()) {
    countryNames[i] = scan.nextLine();
    if (scan.hasNext()) populationNum[i] = scan.nextInt();
    if (scan.hasNext()) scan.nextLine(); // Go to the next line
    i++;
}