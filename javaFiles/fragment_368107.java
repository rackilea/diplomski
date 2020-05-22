File golf = new File("golf.txt");
Scanner scan = new Scanner(golf);
int i = 0;
int parsum = 0, golfsum1 = 0, golfsum2 = 0, golfsum3 = 0, golfsum4 = 0;

ArrayList<Integer> par = new ArrayList<Integer>();
ArrayList<Integer> golfer1 = new ArrayList<Integer>();
ArrayList<Integer> golfer2 = new ArrayList<Integer>();
ArrayList<Integer> golfer3 = new ArrayList<Integer>();
ArrayList<Integer> golfer4 = new ArrayList<Integer>();

while (scan.hasNext()) {
    final int parValue = scan.nextInt(),
        golfValue1 = scan.nextInt(),
        golfValue2 = scan.nextInt(),
        golfValue3 = scan.nextInt(),
        golfValue4 = scan.nextInt();

    parsum += parValue;
    golfsum1 += golfValue1;
    golfsum2 += golfValue2;
    golfsum3 += golfValue3;
    golfsum4 += golfValue4;

    par.add(i, parValue);
    golfer1.add(i, golfValue1);
    golfer2.add(i, golfValue2);
    golfer3.add(i, golfValue3);
    golfer4.add(i, golfValue4);
    i++;
}