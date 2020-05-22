private static boolean designFits(int[] source, int[] target) {

    //if source is bigger than target, it cannot fit
    if (source.length > target.length) {
       return false;
    }

    //sort the arrays
    Arrays.sort(source);
    Arrays.sort(target);

    //get the size difference between target and source
    int targetSizeDiff = target.length - source.length;

    //walk source:
    for (int i = 0; i < source.length; i++) {
       //compare source's value at index i with target's value at i + difference
       //if it's greater, source cannot fit
       if (source[i] > target[i + targetSizeDiff]) {
          return false;
       }
    }

    //at this point we know source can fit
    return true;
}

public static void main(String[] args) {

    //false
    System.out.println(designFits(new int[]{16, 16, 16}, new int[]{13, 13, 22}));

    //true
    System.out.println(designFits(new int[]{12, 12}, new int[]{16, 16, 12}));

    //false
    System.out.println(designFits(new int[]{12, 18, 14}, new int[]{10, 18, 14}));

    //true
    System.out.println(designFits(new int[]{12, 24}, new int[]{10, 12, 24}));

    //false
    System.out.println(designFits(new int[]{10, 10, 10}, new int[]{10, 10}));
}