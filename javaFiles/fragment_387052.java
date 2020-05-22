public class Join {

    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {1, 4, 5};
        int[] c = {2, 4, 5, 6};

        int[] output = new int[a.length + b.length + c.length];

        int aIndex = 0;
        int bIndex = 0;
        int cIndex = 0;

        for(int outputIndex = 0; outputIndex < output.length; outputIndex++) {
            if (aIndex < a.length
                    && (bIndex >= b.length || a[aIndex] <= b[bIndex])
                    && (cIndex >= c.length || a[aIndex] <= c[cIndex])) {
                output[outputIndex] = a[aIndex];
                aIndex++;
            } else if (bIndex < b.length
                    && (aIndex >= a.length || b[bIndex] <= a[aIndex])
                    && (cIndex >= c.length || b[bIndex] <= c[cIndex])) {
                output[outputIndex] = b[bIndex];
                bIndex++;
            } else {
                output[outputIndex] =  c[cIndex];
                cIndex++;
            }
        }
    }
}