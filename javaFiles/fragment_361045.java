System.out.println("Please enter a price: ");
integer = input.nextInt();
count++ ; // count = count +1
sum += integer ; // sum = sum + integer
do { 
    System.out.println("Enter another price? ");
    addPrice = input.next();
    while (addPrice.equalsIgnoreCase("Y")) { // change this line to while user response = no etc may need a enter another number?
        System.out.println("Please enter a price: ");
        integer = input.nextInt();
        count++ ; // count = count +1
        sum += integer ; // sum = sum + integer
    }

}
while (addPrice.equalsIgnoreCase("Y"));