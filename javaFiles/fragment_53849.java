int findMax(int[] arr, int left, int right){

if(right-left == 1) return (arr[right]-arr[left]);

int middle = left + (right-left)/2;

int max1 = findMax(arr, left, middle);
int max2 = findMax(arr, middle, right);

if(max1 >= 0 && max2 >= 0) return max1+max2;

else return Math.max(max1,max2);

}