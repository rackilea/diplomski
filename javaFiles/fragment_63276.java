public class ComponentOrder {

    public static void main(String[] args) {
        new ComponentOrder();
    }

    public ComponentOrder() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                BodyPane body = new BodyPane();

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(body);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                List<Component> components = new ArrayList<Component>(25);
                getContents(body, components);
                LayoutComparator lc = new LayoutComparator(body);
                lc.setComponentOrientation(body.getComponentOrientation());
                Collections.sort(components, lc);
                for (Component comp : components) {
                    System.out.println(comp);
                }
            }
        });
    }

    protected void getContents(Container container, List<Component> components) {
        for (Component comp : container.getComponents()) {
            components.add(comp);
            if (comp instanceof Container) {
                getContents((Container) comp, components);
            }
        }
    }

    public class BodyPane extends JPanel {

        private JTextField fldFirstName;
        private JTextField fldMiddleName;
        private JTextField fldLastName;
        private JTextField fldDateOfBirth;
        private JTextField fldEMail;
        private JButton okButton;
        private JButton cancelButton;

        public BodyPane() {
            setLayout(new BorderLayout());
            add(createFieldsPane());
            add(createButtonsPane(), BorderLayout.SOUTH);
        }

        public JPanel createButtonsPane() {
            JPanel panel = new JPanel(new FlowLayout());
            panel.add((okButton = createButton("Ok")));
            panel.add((cancelButton = createButton("Cancel")));
            return panel;
        }

        protected JButton createButton(String text) {
            return new JButton(text);
        }

        public JPanel createFieldsPane() {
            JPanel panel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(2, 2, 2, 2);
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;

            panel.add(createLabel("First Name:"), gbc);
            gbc.gridy++;
            panel.add(createLabel("Middle Name:"), gbc);
            gbc.gridy++;
            panel.add(createLabel("Last Name:"), gbc);
            gbc.gridy++;
            panel.add(createLabel("Date of Birth:"), gbc);
            gbc.gridy++;
            panel.add(createLabel("EMail:"), gbc);

            gbc.gridy = 0;
            gbc.gridx++;
            gbc.weightx = 1;
            panel.add((fldFirstName = createField("FirstName")), gbc);
            gbc.gridy++;
            panel.add((fldLastName = createField("LastName")), gbc);
            gbc.gridy++;
            panel.add((fldMiddleName = createField("MiddleName")), gbc);
            gbc.gridy++;
            panel.add((fldDateOfBirth = createField("DateOfBirth")), gbc);
            gbc.gridy++;
            panel.add((fldEMail = createField("EMail")), gbc);

            JPanel filler = new JPanel();
            filler.setOpaque(false);

            gbc.gridy++;
            gbc.weightx = 1;
            gbc.weighty = 1;
            panel.add(filler, gbc);

            return panel;
        }

        protected JLabel createLabel(String text) {
            JLabel label = new JLabel(text);
            label.setName(text);
            return label;
        }

        protected JTextField createField(String name) {
            JTextField field = new JTextField(12);
            field.setName("Field-" + name);
            return field;
        }
    }

    public class LayoutComparator implements Comparator<Component>, java.io.Serializable {

        private static final int ROW_TOLERANCE = 10;
        private boolean horizontal = true;
        private boolean leftToRight = true;

        private Component parent;

        public LayoutComparator(Component parent) {
            this.parent = parent;
        }

        void setComponentOrientation(ComponentOrientation orientation) {
            horizontal = orientation.isHorizontal();
            leftToRight = orientation.isLeftToRight();
        }

        public int compare(Component a, Component b) {
            if (a == b) {
                return 0;
            }

            // Row/Column algorithm only applies to siblings. If 'a' and 'b'
            // aren't siblings, then we need to find their most inferior
            // ancestors which share a parent. Compute the ancestory lists for
            // each Component and then search from the Window down until the
            // hierarchy branches.
            if (a.getParent() != b.getParent()) {
                LinkedList<Component> aAncestory = new LinkedList<Component>();

                for (; a != null; a = a.getParent()) {
                    aAncestory.add(a);
                    if (a instanceof Window) {
                        break;
                    }
                }
                if (a == null) {
                    // 'a' is not part of a Window hierarchy. Can't cope.
                    throw new ClassCastException();
                }

                LinkedList<Component> bAncestory = new LinkedList<Component>();

                for (; b != null; b = b.getParent()) {
                    bAncestory.add(b);
                    if (b instanceof Window) {
                        break;
                    }
                }
                if (b == null) {
                    // 'b' is not part of a Window hierarchy. Can't cope.
                    throw new ClassCastException();
                }

                for (ListIterator<Component> aIter = aAncestory.listIterator(aAncestory.size()),
                                bIter = bAncestory.listIterator(bAncestory.size());;) {
                    if (aIter.hasPrevious()) {
                        a = aIter.previous();
                    } else {
                        // a is an ancestor of b
                        return -1;
                    }

                    if (bIter.hasPrevious()) {
                        b = bIter.previous();
                    } else {
                        // b is an ancestor of a
                        return 1;
                    }

                    if (a != b) {
                        break;
                    }
                }
            }

            Point pa = SwingUtilities.convertPoint(a, a.getLocation(), parent);
            Point pb = SwingUtilities.convertPoint(b, b.getLocation(), parent);

            int ax = pa.x, ay = pa.y, bx = pb.x, by = pb.y;

            int zOrder = a.getParent().getComponentZOrder(a) - b.getParent().getComponentZOrder(b);
            if (horizontal) {
                if (leftToRight) {

                    // LT - Western Europe (optional for Japanese, Chinese, Korean)

                    if (Math.abs(ay - by) < ROW_TOLERANCE) {
                        return (ax < bx) ? -1 : ((ax > bx) ? 1 : zOrder);
                    } else {
                        return (ay < by) ? -1 : 1;
                    }
                } else { // !leftToRight

                    // RT - Middle East (Arabic, Hebrew)

                    if (Math.abs(ay - by) < ROW_TOLERANCE) {
                        return (ax > bx) ? -1 : ((ax < bx) ? 1 : zOrder);
                    } else {
                        return (ay < by) ? -1 : 1;
                    }
                }
            } else { // !horizontal
                if (leftToRight) {

                    // TL - Mongolian

                    if (Math.abs(ax - bx) < ROW_TOLERANCE) {
                        return (ay < by) ? -1 : ((ay > by) ? 1 : zOrder);
                    } else {
                        return (ax < bx) ? -1 : 1;
                    }
                } else { // !leftToRight

                    // TR - Japanese, Chinese, Korean

                    if (Math.abs(ax - bx) < ROW_TOLERANCE) {
                        return (ay < by) ? -1 : ((ay > by) ? 1 : zOrder);
                    } else {
                        return (ax > bx) ? -1 : 1;
                    }
                }
            }
        }
    }
}