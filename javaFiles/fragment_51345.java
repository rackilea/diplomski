public class test {
    public static void main(String[] args) {

    int [] data = {1 ,4, 9, 16, 9};
    oddAndEven(data);
}

public static void oddAndEven(int[] data) {

    int total = 0;

    for (int i = 0; i < data.length; i++)
    {
        if (i%2==0)
            total = total + data[i];
        else
            total = total - data[i];
    }

    System.out.println(total);
}