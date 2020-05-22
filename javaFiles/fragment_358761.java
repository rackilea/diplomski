package tigers.bunnies;


public class TableAdapter {

public int tableC[][];//=new int[3][3];
private int dimension;

public TableAdapter(){
    Animal tableT[][];
    tableT = table.getTable();

    dimension=tableT.length;

    //int tableC[][];
    tableC = new int[dimension][dimension];

    for(int i=0;i<dimension;i++){
        for(int j=0;j<dimension;j++){
            if(tableT[i][j]==null){
                tableC[i][j]=0000;
            }
            else if(tableT[i][j] instanceof tiger){
                tableC[i][j]=0001;
            }
            else if(tableT[i][j] instanceof tiger){
                tableC[i][j]=0002;
            }

    }
}
}

public int[][] getTableC() {
    return tableC;
}

public int getDimension() {
    return dimension;
}