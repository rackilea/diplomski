int userWeapon = lineScan.nextInt();
int computerWeapon = lineScan.nextInt();
String possibleTie = lineScan.next();
if (possibleTie.equals("ties"))
    outcomes[userWeapon][computerWeapon] = possibleTie;
else
    outcomes[userWeapon][computerWeapon] = lineScan.next();