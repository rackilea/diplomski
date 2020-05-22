public class Char2DDemo
{
    public static int ROWS = 3;
    public static int COLS = 3;

    public static class Char2D
    {
        private StringBuilder sb = null;
        private int ROWS;
        private int COLS;

        public Char2D(String str, int rows, int cols)
        {
            this.sb = new StringBuilder(str);
            this.ROWS = rows;
            this.COLS = cols;
        }

        public StringBuilder getSb()
        {
            return sb;
        }

        public int getRowCount()
        {
            return ROWS;
        }

        public int getColCount()
        {
            return COLS;
        }

        public int xy2idx(int x, int y)
        {
            int idx = y * getRowCount() + x;
            return idx;
        }

        public int idx2x(int idx)
        {
            int x = idx % getRowCount();
            return x;
        }

        public int idx2y(int idx)
        {
            int y = (idx - idx2x(idx)) / getRowCount();
            return y;
        }

        public Character getCh(int x, int y)
        {
            return getSb().charAt(xy2idx(x, y));
        }

        public void setCh(Character ch, int x, int y)
        {
            getSb().setCharAt(xy2idx(x, y), ch);
        }
    }

    public static void main(String[] args) throws java.lang.Exception
    {
        String test = "ABC"
                    + "DEF"
                    + "GHI";

        Char2D c2d = new Char2D(test, 3, 3);

        System.out.println("Before " + c2d.getSb());
        System.out.println("at [2][2] " + c2d.getCh(2, 2));
        c2d.setCh('J', 0, 0);
        c2d.setCh('K', 2, 2);
        c2d.setCh('M', 1, 1);        
        System.out.println("After " + c2d.getSb());
        System.out.println("at [1][0] " + c2d.getCh(1, 0));
    }
}