Collections.sort(al);
        String[] wordsResult = new String[al.size()];
        int i = 0;
        for (Tuple tuple : al) {
            wordsResult[i++] = tuple.word;
        }
        Stream.of(wordsResult).forEach(System.out::println);
        System.out.println(al);