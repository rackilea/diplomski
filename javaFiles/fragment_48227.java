private static final int[][] a;
private static final int NUM_TYPES  = 2;
private static final int TYPE_EMPTY = 0;
private static final int TYPE_NORMAL = 1;

static { // static initializer  block.
    a = new int[NUM_TYPES][3];
    a [TYPE_EMPTY] =  new int[]{ 0, 0, 0 };
    a [TYPE_NORMAL] = new int[]{ 1, 2, 3 };
}