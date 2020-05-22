public static void main(String args[]) {

    ArrayList<int[]> input = new ArrayList<int[]>();
    input.add(new int[] { 1, 2, 3 });
    input.add(new int[] { 4, 5 });
    input.add(new int[] { 6, 7 });

    combine(input, new int[input.size()], 0);
}

private static void combine(ArrayList<int[]> input, int[] current, int k) {

    if(k == input.size()) {
        for(int i = 0; i < k; i++) {
            System.out.print(current[i] + " ");
        }
        System.out.println();
    } else {            
        for(int j = 0; j < input.get(k).length; j++) {
            current[k] = input.get(k)[j];
            combine(input, current, k + 1);
        }       
    }
}