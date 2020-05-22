int b = 0;
while(b < 5) {
    for (int a = 0; a <=100;a++){
        for(int j = 0; j <=4; j++){
            if (a == arr1[j]){
                arr2[b]=arr1[j];
                b++;
            }
        }
    }
}