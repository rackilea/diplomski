public class ServerClientPickScreen extends AbstractMenuScreen implements FFListener
{
    private FFButton backButton;
    private FFButton clientButton;
    private FFButton serverButton;

    public ServerClientPickScreen()
    {
        super(new ArrayList<FFButton>());
        backButton = new FFListenerButton(new Rectangle(400, 20, 60, 30), "Back", this);
        clientButton = new FFListenerButton(new Rectangle(260, 140, 80, 30), "Client", this);
        serverButton = new FFListenerButton(new Rectangle(140, 140, 80, 30), "Server", this);
        buttons.add(backButton);
        buttons.add(clientButton);
        buttons.add(serverButton);
 ....