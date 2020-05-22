class array_output {

        public static void main(String args[]) 

        {    

            char array_variable [] = new char[10];

            for (int i = 0; i < 10; ++i) {

                array_variable[i] = 'i';

                System.out.print(array_variable[i] + "" );

               // i++; // you are incrementing i again. No need to do if you want  a jump of 1 step.

            }

        } 

    }