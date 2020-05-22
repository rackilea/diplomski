public class MyString {

    private char[] a;

    public MyString(String s) {
        this.a = s.toCharArray();
    }

    public MyString(char[] a) {
       this.a = a;
    }

    public String toString() {
        return new String(a);
    }

    public int length() {
        return a.length;
    }

    public char charAt(int i) {
        return a[i];
    }

    public static MyString valueOf(int i) {
        return MyString.valueOf(i,-1);
    }

    public static MyString valueOf(double d) {
        int decimalPlace = 0;

        while (d != (int)d)
        {
            decimalPlace++;
            d = d*10;
        }

        return MyString.valueOf((int)d,decimalPlace);
    }

    public static MyString valueOf(int i, int decimalSpot) {
        int index=0;
        int digits = (int)(Math.log10(i)+1);
        int stringLength=digits;
        if (decimalSpot == 0) decimalSpot=-1; // Don't return 1234. - just return 1234
        if (decimalSpot != -1) 
        {
            // Include an extra spot for the decimal
            stringLength++;
        }
        char[] b = new char[stringLength];
        for (int j = digits-1; j >= 0; j--) {
            int power = (int) Math.pow(10,j);
            int singleDigit = (int) Math.floor(i/power);
            i = i - power*singleDigit;
            b[index++] = (char) (48 + singleDigit);

            if (decimalSpot==j)
            {
                b[index++] = '.';
            }
        }

        MyString ms = new MyString(b);
        return ms;
    }

    public static void main(String[] args) {        
        MyString ms = MyString.valueOf(12345);
        System.out.println(ms);

        ms = MyString.valueOf(12345.12313);
        System.out.println(ms);
    }

}