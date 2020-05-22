public void ReadFile(String inputfile) throws FileNotFoundException {

File myFile = new File(inputfile);
Scanner sc = new Scanner(myFile);
List<double> doublelist = new ArrayList<Double>();
//this is where you set the delimiter
sc.useDelimiter(",")
    try {
        while (sc.hasNextDouble()) {
            doublelist.add(sc.nextDouble());
        }

    } catch (Exception e) {
        System.out.println("Error");
    }
    sc.close();
}