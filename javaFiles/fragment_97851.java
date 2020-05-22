public class MyPage extends WebPage {
   public MyPage() {
      // your number is generated somehow
      final int value = 24;

      this.add(new Link<Integer>("myLink") {
         @Override
         public void onClick() {
            // do something with the value
            int newValue = value * 2;
         }
      }
   }
}