if(Secretword.indexOf(letter) != -1)
        {
            System.out.println("You entered a letter in the word");

            while(Secretword.indexOf(letter) != -1)
            {
                index = Secretword.indexOf(letter);
                dashes = dashes.substring(0, index) + letter + dashes.substring(index +1);
            }

            System.out.println(dashes);
        }
        else 
        {
            System.out.println("You entered an incorrect letter");
            number++;
        }