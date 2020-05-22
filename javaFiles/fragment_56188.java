boolean askAgain = true;
while(askAgain){
  int index = sc.nextInt();
  if(index > -1 && index < rationals.length){
      System.out.println(rationals[index]);
      askAgain = false;
  }else{
      System.out.println("Please input an acceptable value.")
  }
}