for (int i = 1; i <= 10; i++ ) {
        calculation = number * i;
        if (i % 5 == 0) {
         System.out.println();
        }    
        System.out.printf("%-5s ", calculation);
}