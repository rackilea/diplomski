import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.*;

public class TestUserList {
    public static class UserRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean hasFocus) {
            if (value instanceof UserEntry) {
                UserEntry user = (UserEntry) value;
                JLabel label = (JLabel) super.getListCellRendererComponent(
                        list, user.getName(), index, isSelected, hasFocus);
                if (user.isOnline())
                    label.setIcon(UIManager
                            .getIcon("OptionPane.informationIcon"));
                else
                    label.setIcon(UIManager.getIcon("OptionPane.errorIcon"));
                return label;
            }
            return super.getListCellRendererComponent(list, value, index,
                    isSelected, hasFocus);
        }
    }

    public TestUserList() {
        JFrame frame = new JFrame("User List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JList list = new JList();

        JScrollPane scrollPane = new JScrollPane(list);
        JPanel content = new JPanel(new BorderLayout());
        content.add(scrollPane, BorderLayout.CENTER);
        final DefaultListModel model = new DefaultListModel();
        model.addElement(new UserEntry("John", true));
        model.addElement(new UserEntry("Jesse", false));
        list.setModel(model);

        list.setCellRenderer(new UserRenderer());

        frame.add(content);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

    public class UserEntry {
        private String name;
        private boolean online;

        public UserEntry(String name, boolean online) {
            super();
            this.name = name;
            this.online = online;
        }

        public String getName() {
            return name;
        }

        public Boolean isOnline() {
            return online;
        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestUserList();
            }
        });
    }
}