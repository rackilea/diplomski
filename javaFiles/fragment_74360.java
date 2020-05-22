private void loadGrades(int[] list) throws IOException{

    ArrayList<Integer> grades = new ArrayList<Integer>();

    Scanner scanner = new Scanner(new File("Proj5Data.txt"));

    while(scanner.hasNextInt()){
        grades.add(scanner.nextInt());
    }

    for (int i : list) {
        list[i] = grades.get(i);
    }
}