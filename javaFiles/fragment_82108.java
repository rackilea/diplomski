class ArrayImport {
    public static void main(String args[]) throws FileNotFoundException {
        String fileName = "sales.txt";
        SalesPerson sp = new SalesPerson[4]; //Manually counted

        //Read the file
        Scanner sc = new Scanner(new FileReader(fileName));

        //Copy data to array
        int i = 0;
        while (sc.hasNext()) {
            staff[i] = new SalesPerson();
            staff[i].name = sc.nextLine(); //Error starts here
            staff[i].number = sc.nextLine();
            staff[i].salesAmount = Double.parseDouble(sc.nextLine());
            i++;
        }
    }
}