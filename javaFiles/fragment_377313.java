int[] ints = new int[array.length];
for(int i=0; i<array.length; i++)
{
    try {
        ints[i] = Integer.parseInt(array[i]);           
    } catch (NumberFormatException nfe) {
        //Not an integer 
    }
}