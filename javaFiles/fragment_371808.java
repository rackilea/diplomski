catch (NumberFormatException nfe)
    {
        System.out.println("NumberFormatException: " + nfe.getMessage());
        System.out.println("Please enter the correct information.");
        inString = getString(data, dataType);
    }