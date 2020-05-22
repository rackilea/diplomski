private boolean isDouble(String str) {
    try {
        // check if it can be parsed as any double
        double x = Double.parseDouble(str);
        // check if the double can be converted without loss to an int
        if (x == (int) x)
            // if yes, this is an int, thus return false
            return false;
        // otherwise, this cannot be converted to an int (e.g. "1.2")
        return true;
        // short version: return x != (int) x;
    }
    catch(NumberFormatException e) {
        return false;
    }

}