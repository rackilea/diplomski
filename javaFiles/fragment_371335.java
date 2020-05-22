import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import static javax.swing.Action.NAME;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DaddyATM {

    public static void main(String[] args) {
        new DaddyATM();
    }

    public DaddyATM() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new AtmPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class AtmPane extends JPanel {

        private KeyPadPane keyPadPane;
        private MenuPane menuPane;
        private CardLayout cardLayout;

        private MenuActions menuAction = null;

        public AtmPane() {
            setLayout((cardLayout = new CardLayout()));
            add((keyPadPane = new KeyPadPane()), "keypad");
            add((menuPane = new MenuPane()), "menu");

            menuPane.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String cmd = e.getActionCommand();
                    if (MenuActions.WITHDRAW.isEqualToCommand(cmd)) {
                        menuAction = MenuActions.WITHDRAW;
                        cardLayout.show(AtmPane.this, "keypad");
                    } else if (MenuActions.DEPOSIT.isEqualToCommand(cmd)) {
                        menuAction = MenuActions.DEPOSIT;
                        cardLayout.show(AtmPane.this, "keypad");
                    }
                }
            });

            keyPadPane.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String cmd = e.getActionCommand();
                    if (KeyPadActions.ENTER.isEqualToCommand(cmd)) {
                        double amount = keyPadPane.getValue();
                        switch (menuAction) {
                            case WITHDRAW:
                                System.out.println("You withdrew " + NumberFormat.getCurrencyInstance().format(amount));
                                break;
                            case DEPOSIT:
                                System.out.println("You deposited " + NumberFormat.getCurrencyInstance().format(amount));
                                break;
                        }
                    }
                    cardLayout.show(AtmPane.this, "menu");
                    menuAction = null
                }
            });

            cardLayout.show(this, "menu");
        }

    }

    public enum MenuActions {
        WITHDRAW("withdraw"),
        DEPOSIT("deposit");

        private String command;

        private MenuActions(String command) {
            this.command = command;
        }

        public boolean isEqualToCommand(String cmd) {
            return command.equals(cmd);
        }

        public String getCommand() {
            return command;
        }
    }

    public class MenuPane extends JPanel {

        public MenuPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            add(new JButton(new MenuAction("Withdraw", MenuActions.WITHDRAW)), gbc);
            add(new JButton(new MenuAction("Deposit", MenuActions.DEPOSIT)), gbc);
        }

        public void addActionListener(ActionListener listener) {
            listenerList.add(ActionListener.class, listener);
        }

        public void removeActionListener(ActionListener listener) {
            listenerList.remove(ActionListener.class, listener);
        }

        protected void fireActionPerformed(MenuActions action) {
            ActionListener[] listeners = listenerList.getListeners(ActionListener.class);
            ActionEvent evt = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, action.getCommand());
            for (ActionListener listener : listeners) {
                listener.actionPerformed(evt);
            }
        }

        public class MenuAction extends AbstractAction {

            private MenuActions action;

            public MenuAction(String name, MenuActions action) {
                this.action = action;
                putValue(NAME, name);
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                fireActionPerformed(action);
            }

        }

    }

    public enum KeyPadActions {
        ENTER("enter"),
        CANCELED("canceled");

        private String command;

        private KeyPadActions(String command) {
            this.command = command;
        }

        public boolean isEqualToCommand(String cmd) {
            return command.equals(cmd);
        }

        public String getCommand() {
            return command;
        }

    }

    public class KeyPadPane extends JPanel {

        private JButton[] numbers;
        private JButton cancel, clear, enter;
        private JFormattedTextField amountField;

        public KeyPadPane() {

            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
            amountField = new JFormattedTextField(currencyFormat);
            amountField.setColumns(10);
            amountField.setHorizontalAlignment(JFormattedTextField.RIGHT);
            amountField.setValue(0d);
            amountField.setEditable(false);

            numbers = new JButton[10];
            for (int index = 0; index < numbers.length; index++) {
                numbers[index] = new JButton(new NumberAction(index));
            }

            setLayout(new BorderLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            add(amountField, BorderLayout.NORTH);

            JPanel buttons = new JPanel(new GridLayout(0, 4));

            List<Component> components = new ArrayList<>();
            components.add((cancel = new JButton(new CancelAction())));
            components.add((clear = new JButton(new ClearAction())));
            components.add((enter = new JButton(new EnterAction())));

            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    buttons.add(numbers[(row * 3) + (col + 1)]);
                }
                buttons.add(components.get(row));
            }
            buttons.add(new JButton());
            buttons.add(numbers[0]);
            buttons.add(new JButton());
            buttons.add(new JButton());
            add(buttons);
        }

        public double getValue() {
            return (double) amountField.getValue();
        }

        public void append(int number) {
            Double objValue = (Double) amountField.getValue();
            StringBuilder sb = new StringBuilder(Double.toString(objValue));
            sb.insert(sb.indexOf("."), number);
            amountField.setValue(Double.parseDouble(sb.toString()));
        }

        public void addActionListener(ActionListener listener) {
            listenerList.add(ActionListener.class, listener);
        }

        public void removeActionListener(ActionListener listener) {
            listenerList.remove(ActionListener.class, listener);
        }

        public void clear() {
            amountField.setValue(0d);
        }

        public void enter() {
            fireActionPerformed(KeyPadActions.ENTER);
            clear();
        }

        public void cancel() {
            fireActionPerformed(KeyPadActions.CANCELED);
            clear();
        }

        protected void fireActionPerformed(KeyPadActions action) {
            ActionListener[] listeners = listenerList.getListeners(ActionListener.class);
            ActionEvent evt = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, action.getCommand());
            for (ActionListener listener : listeners) {
                listener.actionPerformed(evt);
            }
        }

        public class ClearAction extends AbstractAction {

            public ClearAction() {
                putValue(NAME, "Clear");
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }

        }

        public class EnterAction extends AbstractAction {

            public EnterAction() {
                putValue(NAME, "Enter");
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                enter();
            }

        }

        public class CancelAction extends AbstractAction {

            public CancelAction() {
                putValue(NAME, "Cancel");
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                cancel();
            }

        }

        public class NumberAction extends AbstractAction {

            private int number;

            public NumberAction(int number) {
                this.number = number;
                putValue(NAME, Integer.toString(number));
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                append(number);
            }

        }
    }

}