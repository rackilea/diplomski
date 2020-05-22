private boolean checkTerm() {
    try
        {
            String str = lGskCompoundNumber;
            if (lPrefix.trim() == "" || lNumber.trim() == "")
                return false;
            Integer.parseInt(lNumber);
            if (lHasAmpersand)
                str = lGskCompoundNumber.replace("&", "");
            return str.equals(lPrefix + lInitSep + lNumber + lEndSep + lSuffix);
        }
        catch (NumberFormatException ex)
        {
            return false;
        }
    }