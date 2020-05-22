public boolean withdraw(double wamt)
  {
    boolean result = false;
    if(withdraw <= wamt)
    {
      balance= balance - withdraw;
      return true;
    }
    return result; 
  }