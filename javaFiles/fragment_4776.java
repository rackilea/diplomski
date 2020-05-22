//CLIENTS LOOP
while (true)
{
    ...

    //MESSAGE LOOP
    while ( true )
    {
         System.out.println(" -> WAITING FOR INCOMING MESSAGE.. ");
         len = inputStream.read(buffer_msg);

         if ( len < 0 )
             break;

         ...