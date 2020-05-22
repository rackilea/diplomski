Map<Integer, Integer> scannedNums = new HashMap<Integer, Integer>();
        for (int counter = left ; counter < list.length ; counter++)
        {
            if(scannedNums.get(list[counter]) == null){
                scannedNums.put(list[counter], 1);
            }else{
                int currentCount = scannedNums.get(list[counter]);
                scannedNums.put(list[counter], currentCount+1);
            }
        }

        Set<Integer> nums = scannedNums.keySet();
        Iterator<Integer> numIter = nums.iterator();
        while(numIter.hasNext()){
            int number = numIter.next();
            System.out.println ("The number " + number + 
                    " was added " + scannedNums.get(number) + " times");
        }