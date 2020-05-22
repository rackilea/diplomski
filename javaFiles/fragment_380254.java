final int MAX_ARRAY_SIZE = (the biggest that your all values array will be)
int index[] = new int[MAX_ARRAY_SIZE];
for(int i = 0; i < allValues.length(); i++)
{
    index[ i ] = i;
}
//Simple Bubble Sort
for(int i = 0; i < allValues.length() - 1; i++)
{
    for(int j = i + 1; j < allValues.length(); j++)
    {
        if(allValues[ index[ i ] ] > allValues[ index[ j ] ])
        {
            int temp = index[ i ];
            index[ i ] = index[ j ];
            index[ j ] = temp;
        }
    }
}
System.out.println("Indexes of 2nd to 4th lowest numbers are the following: ");
for(int i = 1; i < 4; i++)
{
    System.out.println(index[ i ]);
}