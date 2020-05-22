public static String[] giveShifts(LinkedList<Integer> list) {
        //since you need only odd numbers, filter out even ones
        list = list.stream().filter(i -> i % 2 != 0)
                .collect(Collectors.toCollection(LinkedList::new));
        int oddCount = list.size();
        String[] result = new String[oddCount];
        //type cast it to Queue as it will help understand the concept
        // shift is essentially, remove from head and add to tail in queue
        java.util.Queue<Integer> queue = list;
        for(int i=0;i<oddCount; i++){
            queue.add(queue.remove());
            result[i] = queue.stream()
                       .map(element -> element.toString())
                       .collect(Collectors.joining(","));
        }
        return result;
    }