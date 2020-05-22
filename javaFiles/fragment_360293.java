public class Matrix {
    /** a common cell interface */
    public interface ICell {
        public int getX();
        public int getY();
    }

    /** somthing that knows how to produce a cell */
    public interface CellProducerStrategy {
        public ICell getCell(int i, int j, int k);
    }

    /** method of Matrix that is always the same for all Cells and Strategies */
    public ICell[][] populateCells(int xCols, int yRows, CellProducerStrategy strategy) {
        ICell c[][] = new ICell[xCols][yRows];
        int k = 0;
        for (int i = 0; i < xCols; i++){
            for(int j = 0; j < yRows; j++){
                c[i][j] = strategy.getCell(i,j,k);
                k++;
            }
        }
        return c;
    }

    // ---------- some implementation --------------------

    static class DefaultCell implements ICell {
        public DefaultCell(int i, int j, int k) {
            // something
        }
        @Override
        public int getX() {
            return 0;
        }
        @Override
        public int getY() {
            return 0;
        }
    }

    public static class DefaultCellProducer implements CellProducerStrategy {
        @Override
        public ICell getCell(int i, int j, int k) {
            return new DefaultCell(i, j, k);
        }
    }

    // ---------- alternative implementation --------------------

    static class NamedCell implements ICell {
        private String name;
        public NamedCell(int i, int j, int k, String name) {
            // something
            this.name = name;
        }
        @Override
        public int getX() {
            return 0;
        }
        @Override
        public int getY() {
            return 0;
        }
        public String getName() {
            return this.name;
        }
    }

    public static class NamedCellProducer implements CellProducerStrategy {
        @Override
        public ICell getCell(int i, int j, int k) {
            return new NamedCell(i, j, k, "John-" + i*j*k);
        }
    }
}