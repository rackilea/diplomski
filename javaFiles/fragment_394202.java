for (int counter = 0; counter < volume.length; counter++){
           //user input
     try{
          double radius = Double.parseDouble(JOptionPane.showInputDialog("Enter the radius"));
          double height = Double.parseDouble(JOptionPane.showInputDialog("Enter the height"));
          volume[counter] = new Cylinder(radius, height);
     }catch (NumberFormatException e)
                {
                    JOptionPane.showMessageDialog(null,
                            "Error. Please enter a valid number", "Error",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }