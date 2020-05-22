public static void main(String[] args) {
    //Get the unsafe object.
    Unsafe unsafe = null;
    try {
        Field field = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        unsafe = (sun.misc.Unsafe) field.get(null);
    } catch (Exception e) {
        throw new AssertionError(e);
    }
    //define our array
    int[] data = new int[]{0,1,2,3,4,5,6,7,8,9};
    //calculate length (ignoring alignment)
    int len = Unsafe.ARRAY_INT_BASE_OFFSET + Unsafe.ARRAY_INT_INDEX_SCALE * data.length;
    //Some output formatting
    System.out.print(" 0| ");
    for(int i = 0; i < len; i++){
        //unsafe.getByte retrieves the byte in the data struct with offset i
        //This is casted to a signed integer, so we mask it to get the actual value
        String hex = Integer.toHexString(unsafe.getByte(data, i)&0xFF);
        //force a length of 2
        hex = "00".substring(hex.length()) + hex;
        //Output formatting
        System.out.print(hex);
        System.out.print(" ");
        if(i%4 == 3 && i != len -1){
            System.out.println();
            if(i < 9){
                System.out.print(" ");
            }
            System.out.print((i+1) +"| ");
        }
    }
    System.out.println();
}