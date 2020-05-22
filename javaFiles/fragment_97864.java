Scanner sc = new Scanner (System.in);
System.out.print("How old are you? ");
int age = sc.nextInt();

if(age > 40){
  System.out.print("You are more than 40");
}else if(age < 40 && age >= 30){
  System.out.print("You are less than 40");
} else if(age < 30) {
  System.out.print("You are less than 30");
}
....