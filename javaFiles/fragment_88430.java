public static class NaturalNumber {

    private int[] data;

    public NaturalNumber(String initData) {
        final int length = initData.length();
        data = new int[length]; // now we should have enough space
        for(int i = 0; i < length; i++) {
            // Also there won't be any mismatch in size between 
            // initData and the maximum value for i so you don't
            // risk getting a IndexOutOfBoundsException
            data[i] = toInt(initData.charAt(i));
        }
    }

    private static int toInt(char c)
    {
        return (int)c - (int)'0'; // converts a digit character to its integer value
    }

    // possible implementation of compareTo
    public int compareTo(NaturalNumber that) {
        final int length = this.data.length;
        if(length != that.data.length) {
            return Integer.compare(length, that.data.length);
        }

        for(int i = 0; i < length; i++) {
            if(this.data[i] != that.data[i]) {
                return Integer.compare(this.data[i], that.data[i]);
            }
        }
        return 0;
    }

    public void setDigit(int index, int value) {
        if(value < 0 || value > 9) {
            return;
        }
        if(index < 0 || index > data.length - 1) {
            return;
        }
        data[index] = value;
    }
}