public static void MergeSort(int[] array) {
 int current;
 int leftStart;
 int arraySize = array.length;
 for (current = 1; current <= arraySize-1; current = 2 * current) {
for (leftStart = 0; leftStart < arraySize-1; leftStart += 2 * current) {

    int mid = leftStart + current - 1;
    int right = getMin(leftStart + 2 * current - 1, arraySize-1);

    mergeArray(array, leftStart, mid, right);
}}}

 static void printArray(int A[])
 { 
 int i;
  for (i=0; i < A.length; i++)
    System.out.println(A[i]);
    }

 static void mergeArray(int array[], int left, int mid, int right)
   {
   int leftArraySize  = mid - left + 1;
int rightArraySize =  right - mid;

      int[] leftArray  = new int[leftArraySize];
int[] rightArray = new int[rightArraySize];

for (int i = 0; i < leftArraySize ; i++)
    leftArray [i] = array[left + i];
for (int j = 0; j < rightArraySize; j++)
    rightArray[j] = array[mid + 1+ j];

    int leftPtr  = 0;
    int rightPtr  = 0;
    int tempPtr  = left;
while (leftPtr < leftArraySize  && rightPtr  < rightArraySize)
{
    if (leftArray [leftPtr ] <= rightArray[rightPtr ])
    {
        array[tempPtr] = leftArray [leftPtr];
       leftPtr++;
    }
    else
    {
        array[tempPtr] = rightArray[rightPtr];
        rightPtr++;
    }
    tempPtr++;
}

 while (leftPtr < leftArraySize )
{
    array[tempPtr++] = leftArray [leftPtr++];

    leftPtr++;
    tempPtr++;
}

while (rightPtr < rightArraySize)
{
    array[tempPtr++] = rightArray[rightPtr++];

    rightPtr++;
    tempPtr++;
}   }

   public static int getMin(int left, int right) {
   if (left <= right) {
return left;
} else {
   return right;
 }}