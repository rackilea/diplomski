public class MyPage extends WebPage {
       public MyPage() {
          // your number is generated somehow
          int value = 24;

          Model<Integer> model = new Model<Integer>(value);

          this.add(new Link<Integer>("myLink", model) {
             @Override
             public void onClick() {
                // your '24'
                Integer value = this.getModelObject();
                // do something with the value
                int newValue = value * 2;
             }
          }
       }
    }