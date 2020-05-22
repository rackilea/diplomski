// With only arrays
int positivesSize = 0;
int negativesSize = 0;

for(int value : source) {
    if (value < 0) {
        negativesSize++;
    } else {
        positivesSize++;
    }
}

int[] positivesCase1 = new int[positivesSize];
int[] negativesCase1 = new int[negativesSize];

int i = 0;
int j = 0;

for(int value : source) {
    if (value >= 0) {
        positivesCase1[i++] = value;
    } else {
        negativesCase1[j++] = value;
    }
}

System.out.println(Arrays.toString(positivesCase1)); // [4, 6, 2]
System.out.println(Arrays.toString(negativesCase1)); // [-3, -1]