while (!choice.equalsIgnoreCase("n"){
  if(choice.equalsIgnoreCase("y"){
     System.out.print("Enter subtotal:   ");
            double subtotal = sc.nextDouble();

            // calculate the discount amount and total
            double discountPercent = 0;
            if (subtotal <= 100) {
                discountPercent = .1;
            } else if (subtotal <= 200) {
                discountPercent = .2;
            } else if (subtotal >= 500) {
                discountPercent = 0.25;
            }
            double discountAmount = subtotal * discountPercent;
            double total = subtotal - discountAmount;

            // display the discount amount and total
            String message = "Discount percent: " + discountPercent + "\n"
                           + "Discount amount:  " + discountAmount + "\n"
                           + "Invoice total:    " + total + "\n";            
            System.out.println(message);

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.next();
            System.out.println();
    }
    else{
     System.out.print("Please enter (y/n): ");
            choice = sc.next();
            System.out.println();
}
}