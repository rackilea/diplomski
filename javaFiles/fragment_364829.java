public static void main(String[] args) {  
    String[] array1 = 
            {"15", "1", "D1", "Wine",       "1", "0", 
             "15", "3", "D3", "Tap water",  "2", "2",
             "15", "1", "M1", "Fish",       "3", "0",
             "9", "5", "D4", "Coffee",     "2", "2",
             "9", "2", "P2", "Cake",       "2", "1" 
            };
    List<String> list = Arrays.asList(array1);
    Comparator<List<String>> comparator = new Comparator<List<String>>(){
        @Override
        public int compare(List<String>a1, List<String> a2) {
            return Integer.valueOf(a1.get(1)).compareTo(Integer.valueOf(a2.get(1)));
        }
    };
    int lineLength=6;
    System.out.println(list.toString());
    bubbleSort(list,lineLength,comparator);
    System.out.println(list.toString());
}
//classic bubble-sort algorithm
public static void bubbleSort(List<String> list,int lineLength,Comparator<List<String>> comparator){
    int numRow=list.size()/lineLength;
    for(int i=0;i<numRow;i++){
        for(int j=i+1;j<numRow;j++){
            List<String> extractArrayI = extractArray(list, i, lineLength);
            List<String> extractArrayJ = extractArray(list, j, lineLength);
            if(comparator.compare(extractArrayI, extractArrayJ)>0){
                swichLines(list,i,j,lineLength);
            }
        }
    }
}
//extract i-th row
public static List<String> extractArray(List<String> list,int i, int lineLength){
    return list.subList(i*lineLength, i*lineLength+lineLength);
}
//Switch line i,j
public static void swichLines(List<String>list,int i, int j,int lineLength){
    List<String>tempI = new ArrayList<String>(list.subList(i*lineLength, i*lineLength+lineLength));
    List<String>tempJ = new ArrayList<String>(list.subList(j*lineLength, j*lineLength+lineLength));
    replaceSublist(list,tempJ,i,lineLength);
    replaceSublist(list,tempI,j,lineLength);
}
//replace sublist
private static void replaceSublist(List<String> list, List<String> temp, int line, int lineLength) {
    for (int k=0; k<lineLength; k++)
    {
        list.set(line*lineLength+k, temp.get(k));
    }
}