public class Test {

    public static void main(String[] args) throws Exception {

        String numberlist = "1234,1234,1234,1234,1234,1234,1234,1234,1234";
        int splitNumber = 3;
        ArrayList<String> splitList = new ArrayList<String>(Arrays.asList(numberlist.split(",")));

        if (splitList.size() % splitNumber != 0)
            throw new Exception("Number of elelemnts not divisable by split number");

        for (int i = 0; i < splitList.size(); i += splitNumber) {
            System.out.print(((i / splitNumber) + 1) + " group of " + splitNumber +": ");
            for (int j = 0; j < splitNumber; j++) {
                System.out.print(splitList.get(i + j) +", ");
            }
            System.out.println();
        }
    }
}