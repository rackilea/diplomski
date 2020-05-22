public class Swap {
    public static void swap(int[] a){  // now a = x --> {5,3}
        int temp = a[1]; 
        a[1] = a[0];     // swapping a[0] and a[1] in this and next step.
        a[0] = temp;
// NOW only a[] goes out of scope but since both x and a were pointing to the "same" object {5,3}, the changes made by a will be reflected in x i.e, in the main method.
    }

    public static void main(String[] args){
        int[] x = {5,3}; // here - x is a reference that points to an array {5,3}
        swap(x);   
        System.out.println("x[0]:" + x[0] + " x[1]:" + x[1]);
    }
}