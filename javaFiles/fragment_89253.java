public class PaymentProxy implements Payment{

    private PaymentImpl realPayment;

    public PaymentProxy(){

    }

    public void purchase(PaymentVO payInfo, BigDecimal price) throws PaymentException{
       if(realPayment==null){
           realPayment = new PaymentImpl();
       }
       realPayment.purchase(payInfo, price);
    }
}