StringBuilder numbersAboveHalf = new StringBuilder();
  StringBuilder numberBelowHalf = new StringBuilder();
  int countOfNumbersAboveHalf = 0;
  int countOfNumbersBelowHalf = 0;

  for(int x=0; x<randomArray.length; x++){ 
        if(randomArray[x]>499){
            numbersAboveHalf.append(randomArray[x]).append(" ");
            ++countOfNumbersAboveHalf;
        }
        else{
            numbersBelowHalf.append(randomArray[x]).append(" ");
            ++countOfNumbersBelowHalf;
        }
  }
  System.out.println("these " + countOfNumbersBelowHalf + "numbers is between 0 – 499");
  System.out.println(numbersBelowHalf.toString());
  System.out.println("these " + countOfNumbersAboveHalf + "numbers is between 500 – 999");
  System.out.println(numbersAboveHalf.toString());