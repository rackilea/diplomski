public class Test {

    private Test() {
        final String[] arrayOfString = {"A", "B", "C", "D"};

        for(final String s : shift(arrayOfString))
            System.out.println(s);
    }

    private String[] shift(final String[] pArrayOfString)
    {
        final String[] newArray = new String[pArrayOfString.length - 1];

        for(int i = 1; i <= newArray.length; i++)
            newArray[i - 1] = pArrayOfString[i];

        return newArray;
    }

    public static void main(String args[]) {
        Test test = new Test();
    }
}