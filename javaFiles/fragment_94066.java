import java.awt.event.*;
import java.io.File;
import javax.swing.*;

public class Launch extends JFrame implements ActionListener {
private static final long serialVersionUID = 5291490384908841627L;
JButton OK, create;
JList players;
File player;
public static void main(String[] args) {
    new Launch();
}
private Launch() {
    // don't do this
    this.setSize(600, 600);
    this.setLocationRelativeTo(null);
    this.setTitle("A Word Game");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    Box box = Box.createVerticalBox();
    OK = new JButton("OK");
    create = new JButton("Create new player");
    OK.addActionListener(this);
    create.addActionListener(this);
    String[] playerList = getPlayers();
    players = new JList(playerList);
    players.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    JScrollPane scroll = new JScrollPane(players, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    //scroll.add(players);
    final JLabel choosePrompt = new JLabel("Choose a player.");
    box.add(Box.createVerticalStrut(20));
    box.add(choosePrompt);
    box.add(Box.createVerticalStrut(20));
    box.add(scroll);
    box.add(Box.createVerticalStrut(20));
    box.add(OK);
    box.add(Box.createVerticalStrut(20));
    box.add(create);
    box.add(Box.createVerticalStrut(20));
    this.add(box);
    pack();
    this.setVisible(true);
}
private String[] getPlayers() {
    /*File playerDirectory = new File("players");
    File[] playersInFiles = playerDirectory.listFiles();
    String[] players = new String[playersInFiles.length];
    for (int counter = 0; counter < playersInFiles.length; counter ++) {
        players[counter] = trimTXT(playersInFiles[counter].getName());
    }*/
    String[] players = {"Bob", "Jane"};
    return players;
}
private String trimTXT(String original) {
    return original.substring(0, original.length() - 4);
}
@Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(OK)) {
        String name = (String)players.getSelectedValue();
        if (name == null) {
            return;
        }
        player = new File(name + ".txt");
    } else if (e.getSource().equals(create)) {
        //create a new character, all that what-not
    }
}
}