public class Server <T, U> implements Runnable {

   private final Class<T> readObjectType;

   public Server(final Class<T> readObjectType) {
       this.readObjectType = readObjectType;
   }

    @Override
    public void run () {

    try (ObjectInputStream inReader = new ObjectInputStream (this.connection.getInputStream ())) {
        T   lastObj;
        while (true) {
            lastObj = readObjectType.cast(inReader.readObject());
            System.out.println (lastObj.getClass ().getName ());
            if (null != lastObj) {
                this.acceptMessage (lastObj);
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger (this.getClass ().getName ()).log (Level.SEVERE, ex.getMessage (), ex);
        }
    }
}