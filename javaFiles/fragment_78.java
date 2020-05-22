for (int i = 0; i < creditArray.length;) {
    System.out.println("Please enter how many credits "+ courseArray[i] + " is:");
    int input = scan.nextInt();
    if (input >= 1 && input <= 4) {
        creditArray[i++] = input; 
    }
}