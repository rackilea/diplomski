import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;
import javax.swing.event.SwingPropertyChangeSupport;

public class SimpleMVC {
    private static void createAndShowGui() {
        SmvcView view = new SmvcView();
        SmvcModel model = new SmvcModel();
        new SmvcController(view, model);

        view.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}

@SuppressWarnings("serial")
class SmvcView {
    private JPanel mainPanel = new JPanel();
    private CardLayout cardLayout = new CardLayout();
    private JPanel cardPanel = new JPanel(cardLayout);
    private ModelListener modelListener = new ModelListener();
    private SmvcController controller;
    private DefaultComboBoxModel<SmvcState> comboModel = new DefaultComboBoxModel<>(
            SmvcState.values());
    private JComboBox<SmvcState> stateCombo = new JComboBox<>(comboModel);

    public SmvcView() {
        stateCombo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
                DefaultListCellRenderer renderer = (DefaultListCellRenderer) super
                        .getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                SmvcState state = (SmvcState) value;
                if (state != null) {
                    value = state.getText();
                    renderer = (DefaultListCellRenderer) super.getListCellRendererComponent(list,
                            value, index, isSelected, cellHasFocus);
                }
                return renderer;
            }
        });
        stateCombo.addActionListener(evt -> {
            SmvcState state = (SmvcState) stateCombo.getSelectedItem();
            controller.setModelState(state);
        });
        JPanel comboPanel = new JPanel();
        comboPanel.add(stateCombo);

        cardPanel.add(new IntroPanel(), SmvcState.INTRO.toString());
        cardPanel.add(new MainPanel(), SmvcState.MAIN.toString());
        cardPanel.add(new MenuPanel(), SmvcState.MENU.toString());

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(cardPanel, BorderLayout.CENTER);
        mainPanel.add(comboPanel, BorderLayout.PAGE_END);

    }

    public PropertyChangeListener getModelListener() {
        return modelListener;
    }

    public void setController(SmvcController controller) {
        this.controller = controller;
    }

    public void setVisible(boolean b) {
        JFrame frame = new JFrame("Simple MVC");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private class ModelListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (SmvcModel.STATE.equals(evt.getPropertyName())) {
                SmvcState state = (SmvcState) evt.getNewValue();

                cardLayout.show(cardPanel, state.toString());
            }
        }
    }

    private class IntroPanel extends JPanel {
        public IntroPanel() {
            setPreferredSize(new Dimension(400, 300));
            setLayout(new GridBagLayout());
            add(new JLabel(SmvcState.INTRO.toString()), SwingConstants.CENTER);
            setBorder(BorderFactory.createTitledBorder(SmvcState.INTRO.toString()));
        }
    }

    private class MainPanel extends JPanel {
        public MainPanel() {
            setPreferredSize(new Dimension(400, 300));
            setLayout(new GridBagLayout());
            add(new JLabel(SmvcState.MAIN.toString()), SwingConstants.CENTER);
            setBorder(BorderFactory.createTitledBorder(SmvcState.MAIN.toString()));
        }
    }

    private class MenuPanel extends JPanel {
        public MenuPanel() {
            setPreferredSize(new Dimension(400, 300));
            setLayout(new GridBagLayout());
            add(new JLabel(SmvcState.MENU.toString()), SwingConstants.CENTER);
            setBorder(BorderFactory.createTitledBorder(SmvcState.MENU.toString()));
        }
    }

}

class SmvcController {

    private SmvcView view;
    private SmvcModel model;

    public SmvcController(SmvcView view, SmvcModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);

        model.addPropertyChangeListener(view.getModelListener());
    }

    public void setModelState(SmvcState state) {
        model.setState(state);
    }

    public SmvcView getView() {
        return view;
    }

    public SmvcModel getModel() {
        return model;
    }

}

class SmvcModel {
    public static final String STATE = "state";
    private SwingPropertyChangeSupport support = new SwingPropertyChangeSupport(this);
    private SmvcState state = SmvcState.INTRO;

    public void addPropertyChangeListener(PropertyChangeListener modelListener) {
        support.addPropertyChangeListener(modelListener);
    }

    public SmvcState getState() {
        return state;
    }

    // notify listeners whenever state is changed
    public void setState(SmvcState state) {
        SmvcState oldValue = this.state;
        SmvcState newValue = state;
        this.state = state;
        support.firePropertyChange(STATE, oldValue, newValue);
    }

}

enum SmvcState {
    INTRO("Intro"), MENU("Menu"), MAIN("Main");
    private String text;

    private SmvcState(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}