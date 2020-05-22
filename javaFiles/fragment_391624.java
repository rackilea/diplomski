public class puzzle{
        public static void main(String[] args){

            String list[] = { "a", "b", "c","d","e","f","g","h","i","j" };
            int column = 3;

            int rows = list.length/column; //Calculate total full rows
            int lastRowElement = list.length%column;//identify number of elements in last row
            if(lastRowElement >0){
                rows++;//add inclomplete row to total number of full filled rows
            }
            //Iterate over rows
             for (int i = 0; i < rows; i++) {
                int j=i;
                int columnIndex = 1;
                while(j < list.length && columnIndex <=column ){
                    System.out.print("\t"+list[j]);
                    if(columnIndex<=lastRowElement){
                        if(i==rows-1 && columnIndex==lastRowElement){
                            j=list.length; //for last row display nothing after column index reaches to number of elements in last row
                        }else{
                            j += rows; //for other rows if columnIndex is less than or equal to number of elements in last row then add j value by number of rows
                        }

                    }else {
                       if(lastRowElement==0){
                          j += rows;
                       }else{
                        j += rows-1; //for column greater than number of element in last row add j = row-1 as last row will not having the column for this column index.
                       }
                    }

                    columnIndex++;//Increase column Index by 1;
                }

                System.out.println();
                }
        }
    }