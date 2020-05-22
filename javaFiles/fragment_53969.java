Scanner in = new Scanner(System.in);
int laps = in.nextInt();
double speedInKph = 280; // km/h
double lapLength = 10000; // meter
double speedInMpS = speedInKph * 1000 / 3600; // m/s
double secondsPerLap = lapLength / speedInMpS; // m / (m/s) = s
double minutesPerLap = secondsPerLap / 60;
double minutes = minutesPerLap * laps;

System.out.println("Minutes: " + minutes);