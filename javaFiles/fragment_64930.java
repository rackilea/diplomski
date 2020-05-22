public static void main(String[] args){
    ClientGUI x = new ClientGUI("0.0.0.0", 1234);
    OtherClass y = new OtherClass(x);
}

public class otherClass {
     private ClientGUI x;
     public otherClass(ClientGUI x){
          this.x = x;
     }
     public void print(){
          System.out.println(x.tf.getText());
     }
}