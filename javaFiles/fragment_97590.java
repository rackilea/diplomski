public static void main(String[] args) throws Exception {
    // write your code here
        Scanner scanner = new Scanner(new File("C:\\directory\\test.txt"));
        List<BigInteger> bigIntegers = new ArrayList<>();
        while (scanner.hasNext()) {
            bigIntegers.add(new BigInteger(scanner.next()));
        }
        BigInteger total = new BigInteger("0");
        for(BigInteger bigInt: bigIntegers) {
            total = total.add(bigInt);
        }
        System.out.println(total);
    }