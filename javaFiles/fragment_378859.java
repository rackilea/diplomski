public static void main(String[]args)

    {

            int numTests = 0;

            double[] grade = new double[numTests];

            double totGrades = 0;

            double average;

                 int check = 1;


            Scanner keyboard = new Scanner(System.in);


            System.out.print("How many tests do you have? ");

            numTests = keyboard.nextInt();



            grade = new double[(int) numTests];



            for (int index = 0; index < grade.length; index++)

            {

                    System.out.print("Enter grade for Test " + (index + 1) + ": ");

                    grade[index] = keyboard.nextDouble();


                    if (grade[index] < 0 || grade[index]> 100)

                    {
                                    try 

                                      {

                                throw new InvalidTestScore();


                            }

                                       catch (InvalidTestScore e) 

                            {

                                    e.printStackTrace();

                            }
                                        break;

                    }

            }

                for (int index = 0; index < grade.length; index++)
                 {  
                        totGrades += grade[index];



              }

                  average = totGrades/grade.length;


                  System.out.print("The average is: " + average);

    }