List<Integer> nums = Arrays.asList(3,2,4,1);
        List<String> words = Arrays.asList("me","you","myself", "i");
        List<String> sortedWords = new ArrayList<>(words);

        // first copy the words to their future location.
        for(int i = 0; i < words.size(); i++) {
            int idx = nums.get(i)-1;
            sortedWords.set(idx,words.get(i));
        }

        // sort the nums
        Collections.sort(nums);

        // print the lists
        System.out.println(nums);
        System.out.println(sortedWords);