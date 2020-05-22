import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter no of products: ");
        int np = Integer.parseInt(in.nextLine());
        String productName, minPricedProduct = "", input;
        String[] inputArr;
        int price, gst, grossPrice;    
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= np; i++) {
            System.out.print("Enter Product name, Price, GST amount (like productname,1234,123): ");
            input = in.nextLine();
            inputArr = input.split(",");
            productName = inputArr[0];
            price = Integer.parseInt(inputArr[1]);
            gst = Integer.parseInt(inputArr[2]);
            grossPrice = price + gst;
            if (grossPrice < min) {
                min = grossPrice;
                minPricedProduct = productName;
            }
        }
        System.out.println(minPricedProduct);
    }
}