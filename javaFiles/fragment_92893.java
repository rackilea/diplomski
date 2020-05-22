public static void main(String[] args) throws Exception {
        int count = 0;

        int stringSize = 4;
        int maxValue= (int)Math.pow(2, stringSize);

        while(count < maxValue) {
            String binaryString = Integer.toBinaryString(count);

            while(binaryString.length() < stringSize) {
                binaryString = "0" + binaryString;
            }

            System.out.println(binaryString);
            count++;
        }

    }