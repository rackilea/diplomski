@SuppressWarnings("serial")
public class JanelaMain extends JFrame {

private FlowLayout layout                           = new FlowLayout();
private JTextField jtxt_send                        = null;

//CUSTOM SWING COMPONENTS
private ConnectionLog cn_log                = ConnectionLog.getInstance();
private TextLog msg_list                    = TextLog.getInstance();


@SuppressWarnings("serial")
public class ConnectionLog extends JTextField {

private JanelaMain jam = JanelaMain.getInstance();