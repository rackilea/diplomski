public void displayComputer() {
    UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Courier New", Font.BOLD, 16)));
    JOptionPane.showMessageDialog(null, "Inventory Computer Detail \n\n"
            + "Manufacturer:  " + manufacturer
            + "\nModel Name:    " + model
            + "\nMemory Size:   " + memory
            + " GB \nDisk Size:     " + disk
            + " GB \nCPU Type:      " + cPU
            + "\nOptical Drive: " + optical
            + "\nOS Version:    " + oS
            + "\nRetail Price:  $" + String.format("%.2f", retailPrice),
            "Geekazoid Inc.", JOptionPane.INFORMATION_MESSAGE);

}