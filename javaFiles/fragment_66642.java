BufferedReader in = new BufferedReader(in);
Scanner scan = new Scanner(in);

int words=0;
int count=0;
while (scan.hasNext()) {
    salesdata[count++] = new Sales(scan.next(), scan.next(), scan.nextInt(), can.nextInt(), scan.nextInt(), scan.nextDouble());         
    //if ((words+=6)>=50) break;
}