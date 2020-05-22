static boolean hasArrayTwoCandidates (int array[], int sum) {
        boolean flag = false;
    for(int i=0;i<array.length-1;i++){
        for(int j=i+1;j<array.length ;j++){
            if(array[i]+array[j] == sum)
                flag = true;
        }
    }
    return flag;
}