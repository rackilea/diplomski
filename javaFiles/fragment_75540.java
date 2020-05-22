import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

GridBagLayout layout = new GridBagLayout();
GridBagConstraints c = new GridBagConstraints();

JPanel panel = new JPanel();
JLabel label = new JLabel("foo");

panel.setLayout(layout);

c.gridx = 0;
c.gridy = 0;
panel.add(label, c);