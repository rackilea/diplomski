String subLine1 = StringUtils.substringBetween(line1, "Center t", "ID: ");
        String subLine2 = StringUtils.substringBetween(line2, "Center t", "ID: ");
        if(subLine1 != null && subLine1.equals(subLine2)) {
            //the lines equals between 'Center t' and 'ID: '
            //.....
        }