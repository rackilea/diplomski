public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        //print the sum in here 
        System.out.println(sumListRecursive(numbers));


    }

    public static int sumListRecursive(List<Integer> numbers) {
        if (numbers.isEmpty() == true ) {
            return 0;
        }
        else {
            /* removed the print statement from here as it prints each time the function is called and else is executed. */
            return numbers.get(0) + sumListRecursive(numbers.subList(1, numbers.size()));
        }
    }