public class ArraysInJava
{
    public static void main(String[] args)
    {
        int[] a = new int[3]; // a = {0, 0, 0} as default value for int elements is 0
        a[1] = 50; // a = {0, 50, 0}
        Object o = a; // o = a = {0, 50, 0} - casting affects the variable type, the referenced object remains the same (recall that objects are saved by reference)
        int[] b = (int[])o; // b = o = a = {0, 50, 0}
        b[1] = 100; // b = o = a = {0, 100, 0}
        System.out.println(a[1]); // Prints 100
        ((int[])o)[1] = 500; // b = o = a = {0, 500, 0}
        System.out.println(a[1]); // Prints 500
    }
}