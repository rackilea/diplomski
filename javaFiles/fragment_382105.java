protected static final int GRID_SIZE = 18;
protected static final int H_GAP = 32;

@Override
public Dimension getPreferredSize() {
    return new Dimension((grid.getColumns() * GRID_SIZE) + (H_GAP * 2), (grid.getRows() * GRID_SIZE) + 1);
}