private static final char[] first = { '2', '3', '4', '5', '6', '7', '8', '9' };

private static final char[] notFrist = { 'b', 'c', 'd', 'g', 'h', 'j', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v',
        'w', 'z', '2', '3', '4', '5', '6', '7', '8', '9' };

public static void main(final String[] args) throws InterruptedException {
    final char[] result = new char[6];
    int val = 32767;
    while (true) {
        int remainder = val;

        // calculate the last 5 digits and map them to the desired characters
        for (int i = 5; 0 < i; i--) {
            result[i] = notFrist[remainder % notFrist.length];
            remainder /= notFrist.length;
        }
        if (first.length <= remainder) {
            throw new RuntimeException("We cannot convert values >=" + val);
        }

        // calculate the first (=left most) digit and map them to the desired characters
        result[0] = first[remainder];

        System.out.println(new String(result));
        val++;
    }