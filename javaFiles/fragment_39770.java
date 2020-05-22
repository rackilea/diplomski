int newLength = arr.length;
for(int i = 0; i < arr.length; i++)
{    
    if(arr[i].contains(toRemove))
    {
        newLength--;
    }
}
String[] result = new String[newLength];
int count = 0; // count tracks the current index of the output array
for(int i = 0; i < arr.length; i++) // i tracks the current index of the input array
{
    if(!arr[i].contains(toRemove)) {
        result[count] = arr[i]; 
        count++;
    }
}
return result;