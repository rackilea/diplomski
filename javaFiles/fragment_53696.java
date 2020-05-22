public static int difference(int[] setA, int sizeA, int[] setB, int sizeB,
         int[] resultSet) {
    int count = 0;
    boolean flag = true;
    for(int i = 0; i<sizeA ; i++){
        for(int j = 0; j<sizeB ; j++){
            if(setA[i] == setB[j]){
                flag =false;
                break;
            }
        }
        if(flag){
            resultSet[count++] =setA[i];
        }
        flag = true;
    }

    for(int i = 0; i<sizeB ; i++){
        for(int j = 0; j<count; j++){
            if(setB[i] == resultSet[j]){
                flag =false;
                break;
            }
        }
        for(int j = 0; j<sizeA ; j++){
            if(setB[i] == setA[j]){
                flag = false;
                break;
            }
        }
        if(flag){
            resultSet[count++] =setB[i];
        }
        flag = true;
    }

    return count;
}