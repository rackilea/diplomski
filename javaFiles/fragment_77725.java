public void validate(int number) throws NumberHighException, NumberLowException,
                                  NumberNegativeException {
   if(number > 100)
       throw new NumberHighException("Number is High");
   if(number < 10)
       throw new NumberLowException("Number is Low");
   if(number < 0)
       throw new NumberNegativeException("Number is Negative");
   else
       System.out.println("Your Entered Number is valid");
}