public static void main(String[] args) {    
    String[] array1 = 
        {"15", "1", "D1", "Wine",       "1", "0", 
         "15", "3", "D3", "Tap water",  "2", "2",
         "15", "1", "M1", "Fish",       "3", "0",
         "9", "5", "D4", "Coffee",     "2", "2",
         "9", "2", "P2", "Cake",       "2", "1" 
        };
    Comparator<String[]> comparator = new Comparator<String[]>(){
        @Override
        public int compare(String[]a1, String[] a2) {
            return Integer.valueOf(a1[1]).compareTo(Integer.valueOf(a2[1]));
        }
    };
    int lineLength=6;
    bubbleSort(array1,lineLength,comparator);
    System.out.println(Arrays.toString(array1));
}
//classic bubble-sort algorithm
public static void bubbleSort(String[]array1,int lineLength,Comparator<String[]> comparator){
    int numRow=array1.length/lineLength;
    for(int i=0;i<numRow;i++){
        for(int j=i+1;j<numRow;j++){
            String[] extractArrayI = extractArray(array1, i, lineLength);
            String[] extractArrayJ = extractArray(array1, j, lineLength);
            if(comparator.compare(extractArrayI, extractArrayJ)>0){
                swichLines(array1,i,j,lineLength);
            }
        }
    }
}
//extract i-th row
public static String[] extractArray(String[]array,int i, int lineLength){
    String [] a= new String[lineLength];
    System.arraycopy(array, i*lineLength, a, 0, lineLength);
    return a;
}
//Switch line i,j
public static void swichLines(String[]array,int i, int j,int lineLength){
    String [] temp = new String[lineLength];
    System.arraycopy(array, i*lineLength, temp, 0, lineLength);
    System.arraycopy(array, j*lineLength, array, i*lineLength, lineLength);
    System.arraycopy(temp, 0, array, j*lineLength, lineLength);
}