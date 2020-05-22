if (pValues != null)
    {
        Set vSet = pValues.entrySet();
        Iterator vIt = vSet.iterator();

        while(vIt.hasNext())
        {
            Map.Entry m =(Map.Entry)vIt.next();

            vSQL = vSQL.replace("{" + (String)m.getKey() + "}", "'" + (String)m.getValue() + "'");
            vSQL = vSQL.replace("[" + (String)m.getKey() +"]", (String)m.getValue());
        }
    }