public double getDoubleValue()
    {
        double returnValue = 0;
        lblMessage.setText(" ");

        try
        {
            returnValue =   Double.parseDouble(txtInput.getText());

        }
        catch (NumberFormatException nfex)
        {
            lblMessage.setText(nfex.toString());
            lblMessage.setForeground(Color.RED);
            return null;
        }
        return returnValue;
    }