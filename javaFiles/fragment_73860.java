/* in 'method1' */
int temp = array[index];
array[index] = array[mark];
array[mark] = temp;

/* in 'privateMethod1' */
int min = array[first];
int indexOfMin = first;

//...

if (array[index] < min)
{
    min = array[index];
    indexOfMin = index;
}