while (numberPrinted < NUMBER_OF_PALINPRIME) {
     if (isPrime(testedNumber) && isPalindrome(testedNumber)) {
     numberPrinted++;
     System.out.print(String.format("%6s ", testedNumber));//formats to 6 positions

      if (numberPrinted % 10 == 0) {
           System.out.println();
      }
   } 
   testedNumber++;
}