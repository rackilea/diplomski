void permute(String[] items, String[] soFar, int depth) {
    if (depth == soFar.length) {
        System.out.println(Arrays.toString(soFar));
        return;
    }
    for(String item: items) {
        soFar[depth] = item;
            permute(items,soFar,depth+1);
    }
}