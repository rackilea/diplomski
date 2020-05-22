public static int InputInt()
{
    String sInput = UserInputField.getText(); //Gets the string from the JTextField

    int output = Integer.parseInt(sInput.trim()); //Parse string to int

    return output; //Return as int
}