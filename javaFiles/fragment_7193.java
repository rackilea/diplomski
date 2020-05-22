System.out.print("Enter the number of your choice: ");
    int optionNumber = Integer.parseInt(kb.readLine());
    boolean flag = true;
    switch (optionNumber) {
        case 1:
            price = 190.00;
            break;
        case 2:
            price = 410.00;
            break;
        default:
            flag = false;
            System.out.println("ERROR: Invalid number!");
            break;
    }
    if (flag) {
        System.out.print("Enter quantity: ");
        int quantity = Integer.parseInt(kb.readLine());
        totalPrice = price * quantity;
        System.out.print("Total price: " + totalPrice);
    }