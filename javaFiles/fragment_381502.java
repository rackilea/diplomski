class App
{
      public <T extends Msg> ResultSet<T> getResult(Class<T> cls)
     {
         return new ResultSet();
     }
}