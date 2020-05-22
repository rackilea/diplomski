Scanner scan = new Scanner(System.in);//create new scanner object
        int count = 0;
        stringArray = new String[BUFSIZE];
        while (scan.hasNextLine()){//while looop to execute if file has length
            String line = scan.nextLine();//store line into string input
            if (count >= stringArray.length) {
                //call method to double array length
                stringArray = expandArray(stringArray, stringArray.length);
            }
            stringArray[count] = line;
            count++;
        }
        // Shrink array to required size
        String[] temp = stringArray;
        stringArray = new String[count];
        System.arraycopy(temp, 0, stringArray, 0, count);