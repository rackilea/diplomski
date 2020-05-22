public class Elevator {

public static void main(String[] args) {
        new Elevator();
    }

    public Elevator() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new BuildingPane());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public enum ElevatorShaft {
        Left,
        Right
    }

    public interface ElevatorModel {
        public int getFloor();
        public void setFloor(int floor);

        public void addPropertyChangeListener(PropertyChangeListener listener);
        public void removePropertyChangeListener(PropertyChangeListener listener);
    }

    public class DefaultElevatorModel implements ElevatorModel {

        private int floor;
        private PropertyChangeSupport propertyChangeSupport;

        public DefaultElevatorModel(int floor) {
            this.floor = floor;
            propertyChangeSupport = new PropertyChangeSupport(this);
        }

        @Override
        public void addPropertyChangeListener(PropertyChangeListener listener) {
            propertyChangeSupport.addPropertyChangeListener(listener);
        }

        @Override
        public void removePropertyChangeListener(PropertyChangeListener listener) {
            propertyChangeSupport.removePropertyChangeListener(listener);
        }

        @Override
        public int getFloor() {
            return floor;
        }

        @Override
        public void setFloor(int value) {
            if (value != floor) {
                int old = floor;
                floor = value;
                propertyChangeSupport.firePropertyChange("floor", old, floor);
            }
        }

    }

    public interface BuildingModel {

        public int getFloorCount();
        public int getFloor(ElevatorShaft shaft);
        public ElevatorModel getElevatorModel(ElevatorShaft shaft);
        public void call(int floor);

    }

    public class DefaultBuildingModel implements BuildingModel {

        private int floorCount;

        private Map<ElevatorShaft, ElevatorModel> shaftManager;

        public DefaultBuildingModel(int floorCount) {
            this.floorCount = floorCount;
            shaftManager = new HashMap<ElevatorShaft, ElevatorModel>(2);
            shaftManager.put(ElevatorShaft.Left, new DefaultElevatorModel((int)Math.round(Math.random() * (floorCount - 1))));
            shaftManager.put(ElevatorShaft.Right, new DefaultElevatorModel((int)Math.round(Math.random() * (floorCount - 1))));
        }

        @Override
        public ElevatorModel getElevatorModel(ElevatorShaft shaft) {
            return shaftManager.get(shaft);
        }

        @Override
        public int getFloorCount() {
            return floorCount;
        }

        @Override
        public int getFloor(ElevatorShaft shaft) {
            return shaftManager.get(shaft).getFloor();
        }

        @Override
        public void call(int floor) {
            // This will need to determine which elevator should be called
            // and call that elevators model "setFloor" method...
        }

    }

    public class BuildingPane extends JPanel {

        public BuildingPane() {

            setLayout(new GridBagLayout());

            BuildingModel model = new DefaultBuildingModel(3);

            Shaft leftShaft = new Shaft(model, ElevatorShaft.Left);
            Shaft rightShaft = new Shaft(model, ElevatorShaft.Right);
            ButtonsPane buttonsPane = new ButtonsPane(model);

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.VERTICAL;

            add(leftShaft, gbc);
            gbc.gridx++;
            add(buttonsPane, gbc);
            gbc.gridx++;
            add(rightShaft, gbc);

        }

    }

    public class ButtonsPane extends JPanel {

        private BuildingModel model;

        public ButtonsPane(BuildingModel model) {

            this.model = model;

            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weighty = 1;
            gbc.anchor = GridBagConstraints.CENTER;

            int floorCount = model.getFloorCount();
            ActionHandler handler = new ActionHandler();

            for (int floor = floorCount; floor > 0; floor--) {

                JButton button = new JButton("Floor " + floor);
                button.setActionCommand(Integer.toString(floor));
                button.addActionListener(handler);
                add(button, gbc);

                gbc.gridy++;

            }

        }

        public BuildingModel getModel() {
            return model;
        }

        public class ActionHandler implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                try {
                    int floor = Integer.parseInt(cmd);
                    getModel().call(floor);
                } catch (NumberFormatException exp) {
                    exp.printStackTrace();
                }
            }

        }

    }

    public class Shaft extends JPanel {

        private BufferedImage elevator;
        private BuildingModel buildingModel;
        private ElevatorShaft shaft;

        public Shaft(BuildingModel model, ElevatorShaft shaft) {

            this.buildingModel = model;
            this.shaft = shaft;

            buildingModel.getElevatorModel(shaft).addPropertyChangeListener(new PropertyChangeListener() {

                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    if (evt.getPropertyName().equalsIgnoreCase("floor")) {
                        // Need to update our position, this could
                        // be done via animation or directly call something
                        // like repaint..
                    }
                }
            });

            setBorder(new LineBorder(Color.DARK_GRAY));
            setBackground(Color.GRAY);

            try {
                elevator = ImageIO.read(new File("elevator.png"));
            } catch (IOException ex) {
                Logger.getLogger(Elevator.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        public BuildingModel getBuildingModel() {
            return buildingModel;
        }

        public ElevatorShaft getShaft() {
            return shaft;
        }

        public int getFloorCount() {
            return getBuildingModel().getFloorCount();
        }

        public int getFloor() {
            return getBuildingModel().getFloor(getShaft());
        }

        @Override
        public Dimension getPreferredSize() {

            Dimension size = new Dimension(elevator.getWidth(), elevator.getHeight() * getFloorCount());
            Insets insets = getInsets();

            size.width += (insets.left + insets.right);
            size.height += (insets.top + insets.bottom);

            return size;

        }

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            Insets insets = getInsets();
            int x = insets.left;
            int y = insets.top;
            int height = getHeight() - (insets.top + insets.bottom);

            int floor = getFloor();
            y = height - (elevator.getHeight() * (floor + 1));
            g.drawImage(elevator, x, y, this);

        }

    }

}