public class Client{
   public static void main(String[] args){

      PaymentProxy paymentProxy = new PaymentProxy(); //note that the real proxy object is not yet created
      //... code for resolving payInfo and price as per the requirement
      paymentProxy.purchase(payInfo, price); //this is where the real payment object of type PaymentImpl is created and invoked


   }