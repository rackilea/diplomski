public void create() {

    Scanner scan = new Scanner(System.in);

    System.out.println(Colours.getAnsiYellow() + "What is the name of the triathlon?" + Colours.getAnsiReset());
    raceName = scan.nextLine();

    System.out.println(Colours.getAnsiYellow() + "How many participants were there?" + Colours.getAnsiReset());
    participants = new Participant[scan.nextInt()];

    populate(); 

    scan.close();


}