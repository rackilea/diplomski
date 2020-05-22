import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class ChatPanel extends JPanel{
    public ChatPanel() {

        setLayout(new MigLayout("", "[grow][]", "[70px][grow][grow][50px]"));

        JLabel lbConsole = new JLabel("CONSOLE");
        lbConsole.setHorizontalAlignment(SwingConstants.CENTER);
        lbConsole.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel lblMessageDialog = new JLabel("MESSAGE DIALOG");
        lblMessageDialog.setHorizontalAlignment(SwingConstants.CENTER);
        lblMessageDialog.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel lblHeader = new JLabel("HEADER");
        lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
        lblHeader.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel lblServerInfos = new JLabel("SERVER INFOS");
        lblServerInfos.setVerticalAlignment(SwingConstants.TOP);
        lblServerInfos.setHorizontalAlignment(SwingConstants.CENTER);
        lblServerInfos.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel lblConnectedUsers = new JLabel("CONNECTED USERS");
        lblConnectedUsers.setVerticalAlignment(SwingConstants.TOP);
        lblConnectedUsers.setHorizontalAlignment(SwingConstants.CENTER);
        lblConnectedUsers.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        add(lblServerInfos, "cell 1 0 1 2,grow");
        add(lbConsole, "cell 0 1 1 2,grow");
        add(lblHeader, "cell 0 0,grow");
        add(lblConnectedUsers, "cell 1 2,grow");
        add(lblMessageDialog, "cell 0 3 2 1,grow");
    }

}