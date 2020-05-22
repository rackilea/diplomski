for (int index = 0; index < ColorType.length; index++)
{
    String orderItems = JOptionPane.showInputDialog("Please enter the number of T-Shirts for " + ColorType[index]);
    int items = Integer.parseInt(orderItems);
    Color[index] = items;
}