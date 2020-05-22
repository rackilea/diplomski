private int recFind(long search, int lowerBound, int upperBound) {
    if (lowerBound > upperBound) {
        return nElems; // can't find it
    }

    int mid = (lowerBound + upperBound) / 2;

    // print mid and target
    System.out.println("Checking mid= " + a[mid] + " against target=" + search");

    if (search == a[mid]) {
        return mid;  // value found at anArray[mid]
    }
    else             // divide range
    {
        if (a[mid] < search) { // it's in the upper half
            System.out.println("examining upper half");
            return recFind(search, mid+1, upperBound);
        }

        else  {               // it's in the lower half
            System.out.println("examining bottom half");
            return recFind(search, lowerBound, mid-1); 
        }
    }
}