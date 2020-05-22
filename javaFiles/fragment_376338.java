public void run() 
    {

        int i = -1;
        ArrayList<String> list = new ArrayList<String>();
        while ((nextChar=readIn1.read()) != -1) 
        {
            boolean isCompleteMessage = readMessage(nextChar);
            if (isCompleteMessage)
            {
                String[] splitResult = completeMessage .split(",");    
                String header=splitResult[0].trim().substring(0,4);
                if((header.equals("$ACK"))
                {
                    String id = null;
                    if (i != -1)
                    {
                        id = list.get(i);
                        id = id.substring(0,id.indexOf("^"));
                    }
                    //update the message sent from the server as already acknowledge using id extracted above.
                    if ( i == 0)
                    {
                        list.remove(i);
                        if (list.size() == 0)
                        {
                            i = -1;
                        }
                        else
                        {
                            commandText = list.get(i);
                            writeOut1.write(commandText.substring((commandText.indexOf("^")) + 1));
                            writeOut1.write("\r\n");
                            writeOut1.flush(); 
                        }
                    }
                }     
                else
                {
                    //process here the normal message receive from the devices.
                    if (i == -1)
                    {
                        list = getRecords();
                        if (list.size() > 0)
                        {
                            i = 0;
                            commandText = list.get(i);
                            writeOut1.write(commandText.substring((commandText.indexOf("^")) + 1));
                            writeOut1.write("\r\n");
                            writeOut1.flush(); 
                        }
                    }
                    else 
                    {
                        commandText = list.get(i);
                        writeOut1.write(commandText.substring((commandText.indexOf("^")) + 1));
                        writeOut1.write("\r\n");
                        writeOut1.flush(); 
                    }
                } 
                completeMessage = "";
            }   
        }
   }
   public boolean readMessage(int nextChar)
   {
        completeMessage += (char)nextChar;
        if (((char)nextChar) == '*')
        {
            return true;
        }
        else
        {
            return false;
        }
   }
   //Retreive all commands from database and returns the ArrayList containing those commands.
   public ArrayList<String> getRecords()
   {
       ArrayList<String> list = new ArrayList<String>();
       Statement stat = null;
       ResultSet rsOC1 = null;
       try
       {
            stat = con.createStatement();
            rsOC1 = stat.executeQuery("Query for message retrieval from database");
            while (rsOC1.next())
            {
                String sElement = rs0C1.getString("commandID") + "^" + rs0C1.getString("commandText");
                list.add(sElement);
            }
       }
       catch (Exception ex){}
       finally
       {
           if (rs0C1 != null)
           {
               try
               {
                    rs0C1.close();   
               } catch () {}
           }
           if (stat != null)
           {
               try
               {
                    stat.close();   
               } catch () {}
           }
           return list;
       }
   }