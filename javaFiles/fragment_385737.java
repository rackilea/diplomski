int[] numbers =  {24, 15, 22, 10};
        List<Integer> listNumbers = new ArrayList();
        for (int i = 0; i < numbers.length; i++) {
            listNumbers.add(numbers[i]);
        }
        Collections.sort(listNumbers);
        Collections.reverse(listNumbers);
        Integer[] newNumbersArray = listNumbers.toArray(new Integer[listNumbers.size()]);
        for (int i = 0; i < newNumbersArray.length; i++) {
            System.out.println(newNumbersArray[i]);
        }