int seat[][][] = new int [5][][];
int flight = 0;
while (flight < 5) {
    if (Boeing_Number[flight] == 777) {
        seat[flight] = new int[5][3];
    } 
    else if (Boeing_Number[flight] == 747) {
        seat[flight] = new int[10][5];
    }
    flight++;
}