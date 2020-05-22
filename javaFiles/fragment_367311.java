String[] numStrings = n.split("\\D+");
    int[] nums = new int[numStrings.length];
    int i = 0;
    for (String num : numStrings) {
        nums[i] = Integer.parseInt(num);
        i++;
    }