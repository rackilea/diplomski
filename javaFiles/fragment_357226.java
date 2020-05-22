try
    {
        if (Integer.parseInt(ageBox) < 0 || Integer.parseInt(ageBox) > 116)
        {
            log.append("\nError reports\n==========\n");  
            log.append("Age must be in the range of 0-116\n");
            ageField.requestFocus();
        }
    }
    catch (NumberFormatException nfe)
    ...