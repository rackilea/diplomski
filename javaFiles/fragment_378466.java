public class Main {

    public static void main(String[] args) throws ParseException {

        String[] array = new String[10];
        array[0] = "teste1";
        array[1] = "teste2";
        array[2] = "asdf3";
        array[3] = "dfg4";
        array[4] = "xcv";
        array[5] = "324dfg";
        array[6] = "der";
        array[7] = "a";
        array[8] = "sdf1";
        array[9] = "fgdfg7";

        isAscending(array);
    }

    public static void isAscending(String[] array) {

        for (String a : array) {
            System.out.println(a);
        }
        System.out.println("----------");
        Arrays.sort(array);

        for (String ao : array) {
            System.out.println(ao);
        }
    }

}