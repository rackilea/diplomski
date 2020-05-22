public class UserProfilePage extends WebPage {

     public UserProfilePage(PageParameters pageParameters) {
         super(pageParameters);
         StringValue nick = pageParameters.get("nick");
         StringValue action = pageParameters.get("action");
         // any code
         String nickName = nick.toString();
         boolean defaultAction = action.isEmpty(); // default action
     }

}