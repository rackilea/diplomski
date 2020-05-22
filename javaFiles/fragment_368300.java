private static boolean checkDateFormat( String dateString ) 
    {
        String[] possibleDateFormats = new String[] { "yyyy-MM-dd", "yyyy-MM", "yyyy"  };

        boolean isValid = false;

        for ( String possibleDateFormat : possibleDateFormats )
        {
            try
            {
                DateTimeFormatter fmt = DateTimeFormat.forPattern(possibleDateFormat);
                fmt.parseDateTime(dateString.trim());

                isValid = true;
            }
            catch ( Exception e )
            {
            }
        }

        return isValid;
    }