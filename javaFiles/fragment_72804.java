public void itemStateChanged(ItemEvent event)
    {
        if(event.getSource() == items)
        {
            int state = event.getStateChange();
            if(state == ItemEvent.SELECTED)
            {
              String item = (String) items.getSelectedItem();
              JOptionPane.showMessageDialog(null, item , "Items", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else
        {
        }
    }