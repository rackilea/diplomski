public static void main(String[] args) {

    ArrayList<Gastos> billArr = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    int qntItems = 0 , counter = 0;
    String ans;

    while (qntItems == 0) {

        System.out.print("Want to input another item? Y/N: ");
        ans = input.nextLine();

        switch (ans){
            case "y":
                Gastos bill = new Gastos();
                qntItems = 0;
                bill.setDescription();
                bill.setPrice();
                bill.setQuantity();
                bill.getTotal();
                billArr.add(bill);

                counter = counter + 1;
                break;

            case "n": qntItems = 1;
                input.close();
                break;
            default: System.out.print("Invalid!");
                System.out.println();
                break;
        }
    }
    for (Gastos bill : billArr){
        System.out.print(bill.getDescription() + ", " + bill.getPrice() + ", " + bill.getQuantity() + ", " + "the total is: " + bill.getTotal());
    }
}