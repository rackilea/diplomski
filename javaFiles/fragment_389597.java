public int range(int[] num_list) {
    int[] min_max = new int[2];
    for (int i : statues) {
        min_max[0] = (min_max[0] == 0 || i < min_max[0]) ? i : min_max[0];
        min_max[1] = (min_max[1] == 0 || i > min_max[1]) ? i : min_max[1];

        System.out.println(String.valueOf(min_max[0] + " | " + min_max[1]));
    }
}