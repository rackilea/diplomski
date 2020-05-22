//CashDesk
  Client current=null;
  public void nextClient() 
  {
    if(clients.size()==0)
        current=null;
    else
        current = clients.get(0);
 }