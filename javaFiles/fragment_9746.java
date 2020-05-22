public class Simple implements Serializable {

    private transient JFrame win;
    private String username;
    private Date postTime;
    //...assume getters/setters constructors e.t.c.
    private void writeObject( ObjectOutputStream out ) throws IOException {
        out.write( this );
        out.flush();
    }
    private Object readObject( ObjectInputStream in ) throws IOException, ClassNotFoundException {
        Simple s = (Simple) in.read();
        s.setWin( new JFrame( s.getUsername() ) );
        //...any other extra setup can be done here
        return s;
    }

}