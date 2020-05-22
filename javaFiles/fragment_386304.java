public void test6(){
    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter Integers(in a single line separated by space):");

    int[] intArr = null;
    if(scan.hasNext()){
        String line = scan.nextLine();
        intArr = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
    scan.close();
    for(int a: intArr) {
        System.out.println(a);
    }
}