for (int i = 0; i < Recipients_To.length; i++) 
{
    try {
       message.setRecipients(Message.RecipientType.TO,Recipients_To[i].toString());
       Transport.send(message);
    }
    catch (YourException e){
       //Do some thing to handle the exception
    }
}