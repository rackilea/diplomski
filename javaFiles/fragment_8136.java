boolean printMsg = false;
do {
    if (printMsg) {
        System.out.print("MINIMUM IS 1000.00 ");
    }
    printMsg = true;
    System.out.println("Type: Current Minimum of 1000.00 ");
    System.out.print("Amount: " );
    currenttype = Float.parseFloat(in.readLine());
} while (currenttype < 1000);

balance += currenttype;
System.out.print("Successful " + currenttype + " Added to your Account");