System.out.println("Even Numbers are: ");

for(int i = 0; i < yourNumbers.length; i++) {
    if (yourNumbers[i] % 2 == 0) {
        System.out.println(yourNumbers[i]);
    } 
}

System.out.println("Odd Numbers are: ");

for(int i = 0; i < yourNumbers.length; i++) {
    if (yourNumbers[i] % 2 != 0) {
        System.out.println(yourNumbers[i]);
    } 
}