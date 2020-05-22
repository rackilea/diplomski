public static void main(String[] args) {

    int [] RandomArray = new int [5];
    for(int i=0;i<RandomArray.length;i++){
        String element= JOptionPane.showInputDialog("Please insert any number "+ (i+1));
        RandomArray [i]=Integer.parseInt(element);
    }
    int []SortedArray=new int [5];
    int sortArrayLength = 0;
    for(int d=0;d<RandomArray.length;d++) {
        int i = 0;
        int small = RandomArray[i];
        while(sortContains(small, SortedArray)){
            small = RandomArray[++i];
        }
        for(int k=0;k<RandomArray.length;k++){
            int temp = RandomArray[k];
            if(sortContains(temp,SortedArray)){
                continue;
            }
            else{
                if(temp < small){
                    small = temp;
                }
            }
        }
        SortedArray[sortArrayLength++] = small;
    }

    for(int k=0;k< SortedArray.length;k++){
        System.out.println(SortedArray[k]);
    }
}
private static boolean sortContains(int temp, int[] sortedArray) {
    boolean ret = false;
    if(sortedArray == null || sortedArray.length == 0)
        ret = false;
    else {
        for(int i = 0 ; i<sortedArray.length;i++)
            if(temp == sortedArray[i]){
                ret = true;
                break;
            }
    }
    return ret;
}