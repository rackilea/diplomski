Scanner fkc = new Scanner (System.in);
        System.out.println("Enter an Element or something: ");

        String unknown = fkc.nextLine();

        char [] arr = unknown.toCharArray();

        int lastLetterIndex = arr.length - 1;

        if(arr[lastLetterIndex]=='h') {

            System.out.println("ends with H");
        }

        else {

            System.out.println("ends with no H");
        }