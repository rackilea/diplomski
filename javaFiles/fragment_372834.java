private void txtScheduleInfoFocusGained(java.awt.event.FocusEvent evt)                                            
    {                                                
        try
        {
            if (currentClassIsNewClass() && txtScheduleInfo.getDocument().getText(0, txtScheduleInfo.getDocument().getLength()).equals(PASTE_SI_HERE))
            {
                txtScheduleInfo.setForeground(java.awt.SystemColor.textText);
                txtScheduleInfo.setText("");
            }
        }
        catch (BadLocationException ex)
        {
            JOptionPane.showMessageDialog(this, "BLE\nContact Zian", "Unexpected Problem", JOptionPane.ERROR_MESSAGE);
        }
    }