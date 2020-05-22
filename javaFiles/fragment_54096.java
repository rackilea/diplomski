int[] listA = {2, -5, -121, 102, -35, -2, 0, -125, 802, -10, 7, 555};
int[] listB = {6, 99, -1, 12, 1, -2, 7, 555};

// array of flags indicating which elements of listA to copy
int[] listC = new int[listA.length];

// counter of unique elements from listA
int counter = 0;

for (int i = 0; i < listA.length; i++) {
    boolean contains = false;
    //simplified form of for loop if you don't use an index
    for (int b: listB) {
        if (listA[i] == b) {
            contains = true;
            break;
        }
    }
    if (!contains) {
        counter++;
        //setting listC[i] to 1 if listA[i] is not present in listB
        listC[i] = 1;
    }
}

// declaring array with specified size 
int[] listD = new int[counter];

counter = 0;

// iterating through the array of flags to copy unique elements
for (int i = 0; i < listC.length; i++) {
    if (listC[i] == 1) {
        listD[counter++] = listA[i];
    }
}

System.out.println(Arrays.toString(listD));