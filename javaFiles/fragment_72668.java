while(iter.hasNext())
{

    Message queMessage = (Message)iter.next(); //you will be invoking .next() only once

     if(queMessage.data[2].equalsIgnoreCase(ackMessage.data[6]))
     {
          (Integer.parseInt(queMessage.data[6])+1);

     }
}