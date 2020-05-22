public class SquareGrid
{
    /** Lower, left corner of the grid */
    private Point2D m_origin;
    private double  m_cellSize;
    private List<List<List<Point2D>>> m_cells;

    public SquareGrid(Point2D origin, int numberOfCellsPerSide, double cellSize)
    {
        m_origin = origin;
        m_cellSize = cellSize;
        m_cells = new ArrayList<List<List<Point2D>>>(numberOfCellsPerSide);

        for (int i = 0; i < numberOfCellsPerSide; i++)
        {
            List<List<Point2D>> row = new ArrayList<List<Point2D>>(numberOfCellsPerSide);
            m_cells.add(row);

            for (int j = 0; j < numberOfCellsPerSide; j++)
            {
                row.add(new ArrayList<Point2D>>());
            }
        }
    }

    public void add(Point2D point)
    {
        int xCell = Math.floor((point.getX() - m_origin.getX()) / m_cellSize);
        int yCell = Math.floor((point.getY() - m_origin.getY()) / m_cellSize);

        m_cells.get(xCell).get(yCell).add(point);
    }
}