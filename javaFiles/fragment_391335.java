public static void main(String[] args) {
        int[] numbers1;
        int[] numbers2;
        numbers1 = new int[5];
        numbers2 = new int[5];
        int smallest , largest , array_number1, array_number2;
        int smallestOccurence = 0, largestOccurence = 0;
        // create Scanner object
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter 5 numbers: \n");

        for (int counter = 0; counter < numbers1.length; counter++) {
            numbers1[counter] = input.nextInt();
        }
        int smallest1 = numbers1[0], largest1 = numbers1[0];
        // finding smallest and largest value in 1st array
        for (int i : numbers1) {
            if (i < smallest1) {
                smallest1 = i;
            }
            else if (i > largest1) {
                largest1 = i;
            }
        }

        System.out.print("Please enter 5 numbers: \n");
        for (int counter = 0; counter < numbers2.length; counter++) {
            numbers2[counter] = input.nextInt();
        }
        int smallest2 = numbers2[0], largest2 = numbers2[0];

        // finding smallest and largest value in 2nd array
        for (int i : numbers2) {
            if (i < smallest2) {
                smallest2 = i;
            } // end finding smallest
            else if (i > largest2) {
                largest2 = i;
            }  // end finding largest number
        }
        // finding smallest and largest value of both the array.## Heading ##
        if(smallest1 < smallest2){
            smallest=smallest1;
            array_number1 = 1;
        } else {
            smallest=smallest2;
            array_number1 = 2;
        }

        if(largest1 > largest2){
            largest=largest1;
            array_number2 = 1;
        } else {
            largest=largest2;
            array_number2 = 2;
        }

        System.out.printf("Smallest number: %d \t %d \nLargest number: %d \t %d \n", smallest, array_number1, largest, array_number2);
        // You dont know the smallest and largest until we traverse the arrays atleast once. Once we know them we need to search for them in array again.
        for(int item : numbers1) {
            if(item == smallest) smallestOccurence++;
            if(item == largest) largestOccurence++;
        }
        for(int item : numbers2) {
            if(item == smallest) smallestOccurence++;
            if(item == largest) largestOccurence++;
        }
        System.out.println("Occurences of smallest: " + smallest + " and largest: " + largestOccurence);

    }
    public static double counts (int[] sampled, int val)
    {
        int count = 0;
        for (int i = 0; i < sampled.length; i++) {
            if (sampled[i] == val) {
                count++;
            }
        }
        return count;
    }