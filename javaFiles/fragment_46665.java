public void enterValues(Scanner scan, ArrayList<Double> values){
    Double dValue= (double) 0;
    do{
        System.out.println("Enter value to convert: £");
        dValue= scan.nextDouble();
        if(dValue != -1)
            values.add(dValue);
    }while(dValue != -1);

    System.out.println("Values entered. Returning to main menu.");
    mainMenu(scan, values);
}