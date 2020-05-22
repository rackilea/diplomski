int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    Random random = new Random();

    int numsFound = 0;
    int twentyPercent = (int)(nums.length/5F);
    List<Integer> usedIndices = new ArrayList<Integer>();
    while (numsFound < twentyPercent) {
        int index = random.nextInt(nums.length);

        if (!usedIndices.contains(index)) { // not already used?
            System.out.println(nums[index]);
            usedIndices.add(index);
            numsFound++;
        }
    }