if (savedInstanceState != null) {
    final Object[] objects = savedInstanceState.getSerializable("CELLS_STATE");
    final int[][] cells = new int[objects.length][];

    for (int i = 0; i < objects.length; i++) {
        cells[i] = (int[]) objects[i];
    }

    universe = new Universe(cells);
}