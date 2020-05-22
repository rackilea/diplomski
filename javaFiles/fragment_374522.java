public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    LinkedList <Integer> mylist = new LinkedList<> ();
    for(int i = 1; i<=5; i++){
        System.out.print("Process " + i + " has: ");
        int numINPUT = scan.nextInt();
        mylist.add(numINPUT);
    }

    for(int i = 0; i < mylist.size(); i++) {
        for(int j = i + 1; j < mylist.size(); j++) {
            int value1 = mylist.get(i);
            int value2 = mylist.get(j);
            if(value1 == (j + 1) && value2 == (i + 1)) {
                System.out.println("Matched : Process " + (i + 1) + " and Process " + (j + 1) + ".");
            }
        } 
    }
}