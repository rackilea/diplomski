public class TextFieldInfoPage extends WebPage {

    public TextFieldInfoPage() {
        super();
        final TextField<String> firstName = new TextField<String>("firstName");
        firstName.add(new AttributeModifier("info", "Here_I_Want_The_Wicket_Message"));
        add(firstName);
    }

}