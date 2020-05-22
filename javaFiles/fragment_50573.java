Scanner sc = new Scanner(new File("mynums.txt"));
while(sc.hasNextLine()) {
    String[] numstrs = sc.nextLine().split("\\s+"); // split by white space
    int[] nums = new int[numstrs.length];
    for(int i = 0; i < nums.length; i++) nums[i] = Integer.parseInt(numstrs[i]);

    // now you can manipulate the numbers in nums[]

}