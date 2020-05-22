public void addition(){
    int num1 = rand.nextInt(100);
    int num2 = rand.nextInt(100);
    System.out.println(num1 + " + " + num2 + " = ");
    int answer = scan.nextInt();
    if (answer == (num1 + num2)){
           correctanswers++;
    }
}