try
{
    int actualValue = Integer.parseInt(text.getText());

    System.out.println(actualValue);
}
catch (NumberFormatException e)
{
    System.out.println("Not a number");
}