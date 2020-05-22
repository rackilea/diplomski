public class Billboard
{
    private int[] profits;
    private int k;
    public Billboard(int[]profits, int k)
    {
        this.profits = profits;
        this.k = k+1; // I changed this to k+1 because you have 3 totals with k = 2
    }
    public int maximumProfit() {
        int[] bottom = new int[k];

        for(int i = 0; i < profits.length; i++) {
            int minIndex = 0;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                if (bottom[j] < min) {
                    minIndex = j;
                    min = bottom[j];
                }
            }
            bottom[minIndex] += profits[i];
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++) {
            System.out.println("TestDump: #"+i+" is: " + bottom[i]);
            if (bottom[i] < min) {
                min = bottom[i];
            }
        }

        return min;
    }

    public static void main(String args[]) {
        Billboard bb = new Billboard(new int[]{1,2,3,1,6,10}, 2);
        System.out.println("Maximum profit = " + bb.maximumProfit());
    }
}