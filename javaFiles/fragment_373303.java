int max_diff = arr[1] - arr[0]; 
int min_element = arr[0]; 
int max_element = 0; 
int min_element_in_max_difference = 0;
int i; 
for (i = 1; i < arr_size; i++)  
{ 
    if (arr[i] - min_element > max_diff) {
        max_diff = arr[i] - min_element; 
        max_element = arr[i] // New Addition. This part works
        min_element_in_max_difference = min_element; //Newer Addition. Should work!
    }
    if (arr[i] < min_element) 
        min_element = arr[i]; 
}