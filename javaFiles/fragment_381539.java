public class UserListListener implements ActionListener {

    final private Server m_networking;

    //you need to pass a reference to the server to your listener
    //you may also need to pass a reference to the user interface (JList) to your listener as well
    public UserListListener( Server networking ) {
        this.m_networking = networking;
    }

    public String getSelectedUser() {
        //determine the selected user on the JList
    }

    @Override
    public void actionPerformed( ActionEvent e ) {
        String command = e.getActionCommand();
        if ( command.equals( "kick" ) ) {

            //so here, you determine the user that was selected and tell the server to kick him
            server.kick( getSelectedUser() );
        }
    }
}