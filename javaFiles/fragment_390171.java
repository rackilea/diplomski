public static void main(String[] args) 
{
    String name = JOptionPane.showInputDialog("Enter name");
    String zip = JOptionPane.showInputDialog("Enter zip code");
    String size = JOptionPane.showInputDialog("Enter type of car" + "\n" + "e - economy" + "\n" + "m - midsize" + "\n" + "f - full" + "\n" + "l - luxury");
    int days = Integer.parseInt(JOptionPane.showInputDialog("Enter days to rent"))

    CarRental userInfo = new CarRental(name, zip, size, days);

    System.out.println(userInfo.getDailyFee());

    userInfo.display();

}