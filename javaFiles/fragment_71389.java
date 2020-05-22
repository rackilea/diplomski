public static void main(String[] args) {

        Scanner keyboard = new Scanner (System.in);
        System.out.println("Enter up to 10 full names with up to 120 characters and at least two names with at least 4 characters: ");
        String[] fullName= new String[10];
        String[] separatedName;
        String name;
        int i = 0;
        int validCount=0;

        do {
            name = keyboard.nextLine();
            fullName[i]=name;
            i++;

            separatedName =  name.split(" "); 
            //System.out.println(Arrays.toString(separatedName));

            int l = 0; 
            for(int n = 0; n < separatedName .length; n++){
                if(separatedName [n].length() >= 4 ) {
                    l++;
                }
            }
            if(l >= 2 && name.length() <= 120  ) {
                validCount++;
                //System.out.println("Valid name.");
            }
            else {System.out.println("'" +name+ "'" + " is an invalid name");
            }

            if(validCount>=5 || name.equalsIgnoreCase("fim")) {
                break;
            }

        }
        while(i<10);

        keyboard.close();
    }