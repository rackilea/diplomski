double min = list[0];
int minIndex = 0;
double max = list[0];
int maxIndex = 0;
for (int i =1 ; i < list.length ; i++) {
    if(min > list[i]){
        min = list[i];
        minIndex = i;
    }
    if(max < list[i]){
        max = list[i];
        maxIndex = i;
    }
}
int res = Math.abs(minIndex - maxIndex);