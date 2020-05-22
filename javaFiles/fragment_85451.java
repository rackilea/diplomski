for (int count = 0; count < lottoNumbers.length; count++)
 {
   if (count < lottoNumbers.length - 1) {
       System.out.print(lottoNumbers[count]);
       System.out.print(count == lottoNumbers.length - 2 ? "" : ", ");
   } else {
       System.out.println("\nPower Ball: "
                            + lottoNumbers[count]);
   }
 }