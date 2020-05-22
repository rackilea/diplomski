import javax.swing.*;

public class Prop {
  public static void main(String args[]) {

    StringBuilder stringBuilder = new StringBuilder();

    int n = 0;
    n  = Integer.parseInt(JOptionPane.showInputDialog("Enter value"));

    int[] arr = new int[n];
    String stars = "";
    int input = 0;

    for(int c = 0; c<n; c++ ){
      input  = Integer.parseInt(JOptionPane.showInputDialog("Enter number"));
      arr[c]=input;

      for(int i=0; i<input; i++){
        stringBuilder.append("*");
      }
      stars = stringBuilder.toString();
      System.out.println( c +" "+arr[c]+" "+stars);
      stringBuilder.setLength(0);             // Reset the `stringBuilder` once pattern is written
    }
  }
}