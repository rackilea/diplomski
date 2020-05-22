class IntSet{

    private final int MAXALLOWEDSETVALUE = 5; // modified it to a smaller number - easier to debug
    private boolean [] data = new boolean[MAXALLOWEDSETVALUE+1];

    public static void main(String [] args){
        Random rng = new Random();
        rng.setSeed(0);
        IntSet is1, is2, is3;
        is1 = new IntSet(1,2,3);
        is2 = new IntSet(1,2,5);
        is3 = is1.intersectionWith(is2); // I modified the test cases
        System.out.println(is1); // [false, true, true, true, false, false, false]
        System.out.println(is2); // [false, true, true, false, false, true, false]
        System.out.println(is3); // [false, true, true, false, false, false, false]
    }

    @Override
    public String toString() { // added a toString method for a nicer printing
        return Arrays.toString(data);
    }

    public IntSet(int... elts) {
        for(int iteration = 0; iteration < elts.length; iteration++) {
            if(elts[iteration] <= MAXALLOWEDSETVALUE)
                data[elts[iteration]] = true;
        }
    }

    public IntSet intersectionWith(IntSet other) {
        IntSet newSectionSet = new IntSet(); // instead of copying and modifying the copy - just create an "empty" set and update it
        for(int iteration = 0; iteration < MAXALLOWEDSETVALUE; iteration++) {
            if(data[iteration] && other.data[iteration]) { // now the comparison is done directly against `data`
                newSectionSet.data[iteration] = true;
            }
        }
        return newSectionSet;
    }
}