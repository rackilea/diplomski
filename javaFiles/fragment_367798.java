public class PhoneHouse {
     public static void main(String[] args) {
         Phone phone1 = PhoneFactory.getPhone("phone1");
         Phone phone2 = PhoneFactory.getPhone("phone2");
         PhoneListener listener = new PhoneListener() {
             @Override
             public void callEnded(Phone phone) {
                 if (phone.equals(phone1)) {
                     System.out.println("A call ended with phone 1");
                 }
                 else if (phone.equals(phone2)) {
                     System.out.println("A call ended with phone 2");
                 }
             }
         };
         phone1.call("012345678", listener);
         phone2.call("098765432", listener);
     }
}