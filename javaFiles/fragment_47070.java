int n, c;
    Scanner scan = new Scanner(System.in);

    System.out.print("Number of elements: ");
    n = scan.nextInt();
    int[] bubbleSortArray = new int[n];
    int[] selectionSortArray = new int[n];
    int[] insertionSortArray = new int[n];

    System.out.print("Enter " + n + " elements: ");

    for (c = 0; c < n; c++) {
        int i = scan.nextInt();
        bubbleSortArray[c] = i;
        selectionSortArray[c] = i;
        insertionSortArray[c] = i;
    }

    BubbleSort(bubbleSortArray);
    SelectionSort(selectionSortArray);
    InsertionSort(insertionSortArray);