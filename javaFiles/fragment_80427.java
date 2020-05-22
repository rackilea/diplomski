public class ZeroCount {
    public static void main(String[] args) {

        long start = Long.parseLong(args[0]);
        long end = Long.parseLong(args[1]);
        System.out.println("Number of zeros encountered from [" + start + "] to [" + end + "] : " +getZeroCount(start, end));

    }

    public static long getZeroCount(long begin, long end) {
        long zeroCount = 0;
        for (long curNum = begin; curNum <= end; curNum++) {
            if (curNum == 0) {
                zeroCount++;
                continue;   
            }       
            long tempNum = curNum;
            while (tempNum / 10.0 > 0) {
                if (tempNum % 10 == 0) {
                    zeroCount++;    
                }           
                tempNum /= 10;
            }       
        }   
        return zeroCount;

    }
}