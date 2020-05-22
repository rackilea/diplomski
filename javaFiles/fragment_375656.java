//global max value
public static int maxLength = 0;
...
    //inside of Print2DArray.main(String [] args)
    for (int x = 0; x < array.length; x++) {
        for (int y = 0; y < array[x].length; y++) {
            value = (int) (Math.round((value * 100)) / 100.0);
            int numberOfDigits = String.valueOf(value).length();
            if(numberOfDigits > Print2DArray.maxLength)
                Print2DArray.maxLength = numberOfDigits;
            array[x][y] = value;
        }
    }