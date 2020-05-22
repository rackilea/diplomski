public static void displayComputer(Computer computer) {
    UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Courier New", Font.BOLD, 16)));
    JOptionPane.showMessageDialog(null, "Inventory Computer Detail \n\n"
            + "Manufacturer:  " + computer.getManufacturer()
            + "\nModel Name:    " + computer.getModel()
            + "\nMemory Size:   " + computer.getMemory()
            + " GB \nDisk Size:     " + computer.getDisk()
            + " GB \nCPU Type:      " + computer.getCPU()
            + "\nOptical Drive: " + computer.getOptical()
            + "\nOS Version:    " + computer.getOS()
            + "\nRetail Price:  $" + String.format("%.2f", computer.getRetailPrice()),
            "Geekazoid Inc.", JOptionPane.INFORMATION_MESSAGE);

}