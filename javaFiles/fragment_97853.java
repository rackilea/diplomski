public class MyPage extends WebPage {
       public MyPage(PageParameters parameters) {
          // your number is generated somehow
          Integer value = parameters.getAsInteger("value");
       }
    }