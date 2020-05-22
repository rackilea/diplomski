String input = JOptionPane.showInputDialog("Enter Desired Analysis level");
try
{
    int analysisLevel = Integer.parseInt(input);
    if (analysisLevel >= 0) {
        System.out.println(analysisLevel);
    } else {
        input = JOptionPane.showInputDialog("Enter Desired Analysis level");
    }
}
catch (Exception e)
{
    System.out.println("Input was no number. " + e);  
}