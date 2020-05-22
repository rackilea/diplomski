Scanner in = new Scanner(System.in);
System.out.println("Enter up to 5 cards you want to get rid of (1 to quit): ");
while (k<5) { //this is the loop I'm having trouble with
    j = in.nextLine();
    if(j.equals("1") {
        break;
    }
    discard.add(j);
    k++;
}