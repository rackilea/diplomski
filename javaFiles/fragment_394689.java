//method to convert String in Double
public Double getDoubleFromString(String payment) 
{
  payment = payment.substring(1);
  double paymentDouble = Double.parseDouble(payment);
  return paymentDouble;
}

String payment = keyboard.next();
double paymentDouble = getDoubleFromString(payment);

while (paymentDouble != 100.00 && paymentDouble != 50.00 && paymentDouble != 20.00 
           && paymentDouble != 10.00 && paymentDouble != 5.00 
           && paymentDouble != 2.00 && paymentDouble != 1.00) 
      {
         System.out.print("Invalid coin or note. Try again.");
         String payment = keyboard.next();
         paymentDouble = getDoubleFromString(payment);
      }