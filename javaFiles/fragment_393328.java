public class Square extends JPanel {
    private Checker fromChecker;
    private int column;
    private int row;

    Square(int column, int row){
        this.column = column;
        this.row = row;
    }

    public int getColumn(){ 
        return this.column; 
    }

    public int getRow(){ 
        return this.row; 
    }

    // ....