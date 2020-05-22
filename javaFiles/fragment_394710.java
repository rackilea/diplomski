public static void partition(int n, int max, String temp, ArrayList<ArrayList<Integer>> master, ArrayList<Integer> holder) {
    if (n == 0) {
        ArrayList<Integer> temp1 = new ArrayList<Integer>();
        for (int i = 0; i < holder.size(); i++) {
            temp1.add(holder.get(i));
        }
        master.add(temp1);
        System.out.println(temp);
    }

    for (int i = Math.min(max, n); i >= 1; i--) {
        holder.add(i);
        partition(n - i, i, temp + " " + i, master, holder);
        holder.remove(holder.size() - 1);
    }
}