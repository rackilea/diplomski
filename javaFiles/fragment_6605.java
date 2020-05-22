//determining if the guess is correct 
        otherSum = ((digits[0]*10) + digits[1]) * ((digits[2]*100) + (digits[3]*10) + digits[4]);

        if(otherSum == sum)
        {

//Print out digits that work
            for(int i = 0; i < digits.length; i++)
            {

                System.out.println(digits[i]);

//print out the separation between different solutions
                if(i == digits.length -1)
                {

                    System.out.println("next possible solution");

                }    

            }

        }