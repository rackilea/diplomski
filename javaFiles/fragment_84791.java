class IHaveNameVariable
{
    String name;
}

class IAccessNameVariable
{
    public void someMethod()
    {
        // Uncomment the code below
        // and it will compile.

        // IHaveNameVariable aRef = new IHaveNameVariable();

        String userInput = JOptionPane.showInputDialog(null, "What is the value?");
        if(/*aRef.*/name.equals(userInput))
        {
            JOptionPane.showMessageDialog(null, "You are correct.");
        }
    }
}