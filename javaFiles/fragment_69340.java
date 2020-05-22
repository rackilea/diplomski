public class Messages {
    public static final String cancel = "cancel";
}

...

Locale locale = new Locale("en", "US");
ResourceBundle labels = ResourceBundle.getBundle("MyBundle", locale);
System.out.println(labels.getString(Messages.cancel));

...