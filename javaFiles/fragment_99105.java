public class ConwaysGame {

    public static void main(String[] args) {

        int numGenerations = 10;

        // Size of the "universe"
        int universeSize = 12;

        // Initial value
        long cells = 29;

        for(int i=0;i<numGenerations;i++) {

            // Calculate new generation
            long newa=cells>>1;
            long newb=cells<<1;
            cells=newa^newb;

            // Limit the result to the size of the universe
            cells = rightMostBits(cells, universeSize);

            // Output to console
            System.out.println(
                    leftPadZeros(
                        Long.toBinaryString(cells), universeSize
                    )
                );

        }   
    }

    private static long rightMostBits(long data, int numBits){
        // https://stackoverflow.com/questions/2798191/extracting-rightmost-n-bits-of-an-integer
        return data & ((1<<numBits)-1);
    }

    private static String leftPadZeros(String str, int len){
        int numzeros = Math.max(len - str.length(), 0);
        return new String(new char[numzeros]).replace("\0", "0") + str;
    }
}