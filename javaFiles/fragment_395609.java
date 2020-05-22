package Exercises;
import java.util.Scanner;

public class ArrayPlusN {
static int arraySet[];

    public void createArray(int indeces){
        Scanner in = new Scanner(System.in);
        int valueAdded, y = 0;
        arraySet = new int[indeces];
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ArrayPlusN object=new ArrayPlusN();
        int indeces;
        System.out.print("Enter how many array index/indeces you want: ");
        indeces = in.nextInt();
        object.createArray(indeces);
        object.fillArray();
        object.addElement();
    }

    public void fillArray(){
        Scanner in=new Scanner(System.in);
        for(int i=0;i<arraySet.length;i++){
            System.out.println("Enter element number "+(i+1));
            arraySet[i]=in.nextInt();
        }
        System.out.println("The elements of your array are");
        for(int i:arraySet)
        System.out.print(i+" ");
        System.out.println();
    }

    public void addElement(){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter value to be added to each element");
        int valueAdded = in.nextInt();
        int y=0;
        System.out.println("These are the elements in your array when we added "+ valueAdded + " to each: ");
        for(int i:arraySet){
             arraySet[y]=i+valueAdded;
            System.out.printf("%s ", i+valueAdded);
            y++;
        }
    }
}