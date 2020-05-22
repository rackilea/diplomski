ArrayList<ArrayList<Integer>> colors = new ArrayList<ArrayList<Integer>>();

// initialize outer arrays
final int height = 3; // this is your first known dimension
for (int i = 0; i < height; i++) {
    colors.add(new ArrayList<Integer>());
}

// now all lists from the first dimension (height) are initialized with empty lists
// so you can put add some colors to height 0 like this ...
colors.get(0).add(1);
colors.get(0).add(4);
colors.get(0).add(5);

// ... or add one color to height 1
colors.get(1).add(7);