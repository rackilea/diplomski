public static void main(String[] args) { 
  int arr[] = {9,9,9}; 
  int arr1[] = {9,9,9}; 
  int sum[] = {0,0,0}; 
  for (int i=0; i < arr.length; i++) 
    sum = arr[i] + arr1[i]; 
  System.out.println(sum); 
}