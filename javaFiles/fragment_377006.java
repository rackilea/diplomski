class MyProg {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Printing the file passed in:");
        while(sc.hasNextLine()) System.out.println(sc.nextLine());
    }
}