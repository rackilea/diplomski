for ( String FLD: GHA.keySet() )
    {
        boolean appended = false;           
        for ( int i = 0 ; i < GST.size(); i++)
        {
            if ( GHA.get(FLD).containsKey(  GST.get(i)  ) ) {
                GHAS.get(FLD).append("1,");
                appended = true;
                // optionally break here if you don't want multiple 1s
            }

        }
        if (!appended) {
            GHAS.get(FLD).append("0,"); // instead of those 2 lines
        }
    }

    String resultString =  stringWriter.toString();

    for ( String FLD: GHA.keySet() )
        resultString += FLD+ "," +GHAS.get(FLD).toString() + System.getProperty("line.separator");