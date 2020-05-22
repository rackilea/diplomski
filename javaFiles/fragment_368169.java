public class Cell{
    private String name ;
    private float value ;

    public Cell(){.....}
    public float getValue(){......}
    public String getName(){........}

    //if possible only getters and setter here
    }
}


public class CellManagement{

    //hold the array here and access it via getter
    private Cell[] humanoids;

    public CellManagement() {
        Cell monkey_dna = new Cell();
        Cell man_dna = new Cell();
        Cell hen_dna = new Cell();
        humanoids = {monkey_dna,man_dna, hen_dna}
    }

    public void print_array_cells(){
        for(int i = 0 ; i < humanoids.length; i++){
            printcell(humanoids) // just code
        }
    }

    //add and remove functions..

}

public static void main....{

        CellManagement cm = new CellManagement();
        cm.print_array_cells() ;                             
   }
}