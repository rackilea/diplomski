public static void main(String[] args) {

    // starting from 1 since 0000 is not needed
    for(int i=1; i<16; ++i) {

        // bitwise operation & detects 1 in given position,
        // positions are determined by sa called "masks" 
        // mask has 1 in position you wish to extract
        // masks are 0001=1, 0010=2, 0100=4 and 1000=8
        if( (i & 1) > 0 ) System.out.print("A");
        if( (i & 2) > 0 ) System.out.print("B");
        if( (i & 4) > 0 ) System.out.print("C");
        if( (i & 8) > 0 ) System.out.print("D");

        System.out.println("");

    }
}