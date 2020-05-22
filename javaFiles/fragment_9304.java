public void actionPerformed(ActionEvent e)        // the buttons respond when clicked
{  
    if (e.getActionCommand()=="Beenden") {
        ...
    }      
    else if(e.getActionCommand()=="Ausgabe")
    {
      getContentPane().repaint();

      String labelText = "";

      //Using the static List
      for (int i = 0; i < MousePanel.coordinates.size(); i++) {
        labelText += "(" + String.valueOf(MousePanel.coordinates.get(i).getX()) + ")(" + String.valueOf(MousePanel.coordinates.get(i).getY()) + ")\n";
      }

      //Using the stored instance
      for (int i = 0; i < storedMousePanel.coordinates.size()) {
        labelText += "(" + String.valueOf(storedMousePanel.coordinates.get(i).getX()) + ")(" + String.valueOf(storedMousePanel.coordinates.get(i).getY()) + ")\n";
      }

      label.setText(labelText);
    }
    else if(e.getActionCommand()=="Exit")
    {
      System.exit(0);
    } 
    else if (e.getActionCommand()=="Reset")        // clears the JPanel
    {
      getContentPane().repaint();
      label.setText("");
    }
 }