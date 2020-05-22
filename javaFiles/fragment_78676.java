public static int oddFactorial(int number){

            if (number%2==0){
                return (0);}              
                int counter = 1;
                int toReturn= 1;
                while (counter <= number){
                    toReturn = toReturn*counter;
                    counter+=2;
                }
                return toReturn;          
            }


        public static void main(String[] args) {
             int number = 7;
           **System.out.println(oddFactorial(number));**

         }

     }