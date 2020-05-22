private MyException NewException(string message)
{
   MyException e = new MyException(message);
   Logger.LogException(message, e);
   return e;
}

// and elsewhere...
if(mustThrow)
{
   throw NewException("WHOOOOPSIEE!");
}