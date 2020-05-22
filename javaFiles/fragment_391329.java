import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TestMVC {

    public static class ModelObject {
        private PropertyChangeSupport pcs;

        public ModelObject() {
            pcs = new PropertyChangeSupport(this);
        }

        public PropertyChangeSupport getPropertyChangeSupport() {
            return pcs;
        }
    }

    public static class Model extends ModelObject {

        private List<Item> items;

        public Model() {
            items = new ArrayList<TestMVC.Item>();
        }

        public List<Item> getItems() {
            return items;
        }

        public void addToItems(Item item) {
            item.setModel(this);
            items.add(item);
            getPropertyChangeSupport().firePropertyChange("item", null, item);
        }

        public void removeFromItems(Item item) {
            items.add(item);
            item.setModel(null);
            getPropertyChangeSupport().firePropertyChange("item", item, null);
        }

    }

    public static class Item extends ModelObject {
        public static final String VALUE = "value";

        public static final String LABEL = "label";

        public static final String ENABLED = "enabled";

        private Model model;

        private boolean enabled;
        private String label;
        private int value;

        public Item() {
        }

        public Item(boolean enabled, String label, int value) {
            super();
            this.enabled = enabled;
            this.label = label;
            this.value = value;
        }

        public Model getModel() {
            return model;
        }

        public void setModel(Model model) {
            this.model = model;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            boolean old = this.enabled;
            this.enabled = enabled;
            getPropertyChangeSupport().firePropertyChange(ENABLED, old, enabled);
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            String old = this.label;
            this.label = label;
            getPropertyChangeSupport().firePropertyChange(LABEL, old, enabled);
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            _internalSetValue(value);
            if (this.isEnabled()) {
                for (Item item : model.getItems()) {
                    if (item != this && item.isEnabled()) {
                        item._internalSetValue(value);
                    }
                }
            }
        }

        private void _internalSetValue(int value) {
            int old = this.value;
            this.value = value;
            getPropertyChangeSupport().firePropertyChange(VALUE, old, value);
        }
    }

    public static class ItemView implements PropertyChangeListener {
        private Item item;

        private JLabel label;
        private JSlider slider;
        private AbstractButton button;

        public ItemView(Item item) {
            super();
            this.label = new JLabel(item.getLabel());
            this.slider = new JSlider(0, 100);
            this.slider.setValue(item.getValue());
            this.slider.setEnabled(item.isEnabled());
            this.button = new JCheckBox((String) null, item.isEnabled());
            this.item = item;
            item.getPropertyChangeSupport().addPropertyChangeListener(this);
        }

        public JLabel getLabel() {
            return label;
        }

        public JSlider getSlider() {
            return slider;
        }

        public AbstractButton getButton() {
            return button;
        }

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getPropertyName().equals(Item.LABEL)) {
                label.setText(item.getLabel());
            } else if (evt.getPropertyName().equals(Item.ENABLED)) {
                button.setSelected(item.isEnabled());
                slider.setEnabled(item.isEnabled());
            } else if (evt.getPropertyName().equals(Item.VALUE)) {
                slider.setValue(item.getValue());
            }
        }
    }

    private Model model;

    public TestMVC(Model model) {
        super();
        this.model = model;
    }

    protected void initUI() {
        JFrame frame = new JFrame(TestMVC.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc1 = new GridBagConstraints();
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.weightx = 1.0;
        gbc3.fill = GridBagConstraints.HORIZONTAL;
        gbc3.gridwidth = GridBagConstraints.REMAINDER;
        for (final Item item : model.getItems()) {
            final ItemView view = new ItemView(item);
            view.getButton().addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    item.setEnabled(view.getButton().isSelected());
                }
            });
            view.getSlider().addChangeListener(new ChangeListener() {

                @Override
                public void stateChanged(ChangeEvent e) {
                    item.setValue(view.getSlider().getValue());
                }
            });
            panel.add(view.getButton(), gbc1);
            panel.add(view.getLabel(), gbc1);
            panel.add(view.getSlider(), gbc3);
        }
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private static Model loadModel() {
        Random random = new Random();
        Model model = new Model();
        for (int i = 0; i < 10; i++) {
            Item item = new Item(random.nextBoolean(), "Some label " + random.nextLong(), random.nextInt(100));
            model.addToItems(item);
        }
        return model;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                Model model = loadModel();
                new TestMVC(model).initUI();
            }
        });
    }

}