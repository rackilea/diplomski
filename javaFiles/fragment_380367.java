int number1 = scanner.nextInt();
int number2 = 0;
while (true) {
        number2 = scanner.nextInt();       

        if (number1 == number2){
            System.out.println("Woo!");
            break;
        }
       number1 = number2;

}