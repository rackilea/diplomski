public class Test {
    public static void main(String[] args) {
        char chrUserLetter='E';
        int intHeight = chrUserLetter - 'A' + 1;

        for ( int intRowIndex = 1; intRowIndex <= intHeight; intRowIndex += 1 )
        {
            char chrCurrentLetter = chrUserLetter;
            for (int intColumnIndex = 1; intColumnIndex <= intRowIndex; intColumnIndex += 1)
            {
                System.out.print( chrCurrentLetter );
                chrCurrentLetter -= 1;
            }

            System.out.println();
        }
    }
}