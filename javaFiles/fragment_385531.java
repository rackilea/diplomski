interface Callback {
   void visit(int[] p); // n-dimensional point
}

// bounds[] - each number the limits iteration on i'th axis from 0 to bounds[i]
// current - current dimension
// callback - point
void visit(int[] bounds, int currentDimension, int[] p, Callback c) {
   for (int i = 0; i < bounds[currentDimension]; i++) {
        p[currentDimension] = i;
        if (currentDimension == p.length - 1) c.visit(p);
        else visit(bounds, currentDimension + 1, p, c);
   }
}

/// now visiting
visit(new int[] {10, 10, 10}, 0, new int[3], new Callback() {
   public void visit(int[] p) {
        System.out.println(Arrays.toString(p));
   }
});