public class Kernel {

    private final double[][] matrix;

    public Kernel(int sidelength){
        if((sidelength&1)==0)throw new IllegalArgumentException();
        matrix = new double[sidelength][sidelength];
    }


    public double getValueAt(int x, int y){
        return matrix[x][y];
    }
    public void setValueAt(int x, int y, double value){
        matrix[x][y] = value;
    }
    public double sum(){
        double sum = 0.0d;
        for(double[] da:matrix){
            for(double d:da){
                sum+=d;
            }
        }
        return sum;
    }
    public double[][] getFullKernal(){
        return matrix;
    }
    public int getSideLegth(){
        return matrix.length;
    }
    public void normalize(){
        double normalizedConstant = 1d/sum();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                matrix[i][j] = matrix[i][j]*normalizedConstant;
            }
        }
    }
}