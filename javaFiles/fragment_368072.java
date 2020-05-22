if (nConversion == 1) {        
    System.out.print("Please enter the gallons: ");
    double dGal = input.nextDouble();
    double litres = calculateGallonsToLiters(dGal);
    printResult("litres", litres);
}