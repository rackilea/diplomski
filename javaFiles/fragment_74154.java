public static void add(String[] args) {
    // initializing a new integer array of size args.length
    // Well every new int array has its values on 0, so sum over all 0 is 0
    // that's not really surprising
    int[] add = new int[args.length];

    // something is missing in here!
    for (int j = 0; j < args.length; j++) {
        add[j] = Integer.parseInt(args[j]);
    }
    // missing end

    int sum = 0;
    for (int i = 1; i < add.length; i++) {
        sum += add[i];
    }
    System.out.println(sum);
}