public static void main(String[] arg) throws Exception
{
    ArrayList<String> logo = new ArrayList<String>();

    initialize(logo);

    JOptionPane.showMessageDialog(null, logo);
}

private void initialize(ArrayList<String> logo)
{
    logo.add("Blah blah");
    logo.add("Blah blah");
}