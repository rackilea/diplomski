String age = "0";
    try
    {
        age = JOptionPane.showInputDialog("What was your age yesterday?");
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, "Thanks a lot, you broke it. CYA later.");
        return;
    }
    int iage = Integer.parseInt(age);