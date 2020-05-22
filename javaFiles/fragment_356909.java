SwingUtilities.invokeLater(new Runnable()
{
    public void run()
    {
        this.addItem("ok");
        // I can never remember the correct way to invoke a class method            
        // from witin and anonymous inner class
        //InputField.addItem("ok"); 
    }
});