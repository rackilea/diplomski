String[] colors = new String[] {"blue", "orange", "green", "black", "red"};
int[] lines     = new int[]    {    17,        4,       5,       8,     8};

List<Pair> pairs = new LinkedList<Pair>();
for (int i = 0; i < colors.length; i++)
    pairs.add(new Pair(colors[i], lines[i]));