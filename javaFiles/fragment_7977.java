public static void main(String[] args) throws FileNotFoundException {
    File towers = new File("towers.txt");
    File readings = new File("readings.txt");
    Scanner towers1 = new Scanner(towers);      // remember to initialize
    Scanner readings1 = new Scanner(readings);  // the Scanner with the file
    ArrayList<Integer> towerPos = new ArrayList<Integer>();
    ArrayList<Integer> readingPos = new ArrayList<Integer>();

    while(towers1.hasNextDouble()) {
        towerPos.add((int)towers1.nextDouble());
    }

    while(readings1.hasNextDouble()) {
        readingPos.add((int)readings1.nextDouble());
    }

    JFrame f = new JFrame("Cellphone Coverage");
    f.setVisible(true);     
    f.setSize(500, 500);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.add(new CoveRage(towerPos, readingPos));
}