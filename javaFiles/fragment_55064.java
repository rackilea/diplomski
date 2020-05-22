int min = 2017, max = 3017;
int count = max - min + 1; //we're including upper bound
int[] anArray = new int[count];
for (int i = 0; i < count; i++, min++) {
    anArray[i] = min; //reused and incremented min
}