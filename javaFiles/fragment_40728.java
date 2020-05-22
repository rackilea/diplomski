List<Integer> nums = Arrays.asList(3, 2, 4, 1);
        List<String> words = Arrays.asList("me", "you",
                "myself", "i");

        for (int i = 0; i < nums.size() - 1; i++) {
            int n = nums.get(i);
            int savek = i;
            for (int k = i + 1; k < nums.size(); k++) {
                if (n > nums.get(k)) {
                    savek = k; // save index for max value
                }
            }
            // swap if necessary   
            if (savek != i) {
                swap(nums, i, savek);
                swap(words, i, savek);
            }
        }

        // print the lists
        System.out.println(nums);
        System.out.println(words);