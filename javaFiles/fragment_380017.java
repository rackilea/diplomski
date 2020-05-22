public static void main(final String[] args) {
         Scanner input = new Scanner(System.in);
            ArrayList<Integer> list = new ArrayList<Integer>();
            System.out.print("Enter integers please ");
            System.out.println("(EOF or non-integer to terminate): ");

            while (input.hasNextInt()) {
                list.add(input.nextInt());
            }

            Integer[] nums = list.toArray(new Integer[0]);
            System.out.printf("%s", "You entered: ");
            for (int i = 0; i < nums.length; i++) {         
                System.out.printf("%d%s", nums[i], ", ");
            }
            ArrayList<Integer> ori = new ArrayList<Integer>(list);
            Collections.sort(list);
            int b = Collections.max(list);
            int c = Collections.min(list);
            int arraySize = nums.length-1;
            double sum = 0;

            for(int i = 0; i < list.size(); i++)
            {
                sum += list.get(i);
            }
            System.out.println(" \nLast Number is : " + ori.get(list.size()-1)
                    + "\nLargest Number is: " + b 
                    + "\nSmallest number is :" + c 
                    + "\n" + "You entered " + (arraySize+1) + " numbers"
                    + "\nTotal numbers added up is: " + sum 
                    + "\nAverage number is: " + (sum / (nums.length)));
            input.close();

    }