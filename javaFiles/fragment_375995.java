public static void main(String[] args)
{
    Locale.setDefault(new Locale("es", "ES"));
    ResourceBundle test = ResourceBundle.getBundle("test");
    System.out.println(test.getString("message"));
}