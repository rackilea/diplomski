public static void main(String[] args) 
    {
        // TODO Auto-generated method stub
        String name = "rania";
        String endString = "xyz";
        Scanner input= new Scanner(System.in);

        String aString =input.next();

        // Assume name will not be found6
        Boolean isNameFound = false;

        while(!aString.equals(endString))
        {   
            if (aString.equals(name))
            {
                isNameFound = true;
                // This is to ensure program does not quit when the name is found
                // break;  
            }

            aString = input.next();
        }


        if(isNameFound)
        {
            System.out.println("My name FOUND");
        }
        else
        {
            System.out.println("My name NOT FOUND");
        }
    }