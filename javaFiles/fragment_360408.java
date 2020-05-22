class CellProject1 implements Cell {

   private Cell cell;

   CellProject1 (Cell cell){
      this.cell = cell;
   }

   public int getValue(){
      cell.getValue();
   } 

   public void setValue(int value){
      cell.setValue(value);
   }

   public void draw(){
   ...
   }

}