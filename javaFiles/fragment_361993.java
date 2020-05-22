getElementAt(double[] arr, int index)
{
    index = index % arr.length;
    index = index + arr.length; // If index is negative, modulus division gives us negative result, so this makes it positive.
    index = index % arr.length; // In case the previous step made index >= n
    return arr[index]
}