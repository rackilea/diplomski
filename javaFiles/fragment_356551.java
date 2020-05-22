package jzoom.transform;

import ...

public class ZoomPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private AffineTransform transform;
    private TransformUI layerUI;
    private JLayer<JComponent> layer;

    private SpringLayout layout;
    private JPanel springPanel;

    private Container view = null;

    public ZoomPanel() {
        this(null);
    }

    public ZoomPanel(Container view) {

        setLayout(new BorderLayout());

        this.view = view;
        transform = new AffineTransform();

        layout = new SpringLayout();
        springPanel = new JPanel(layout);
        if (view != null) {
            updateConstraints();
            springPanel.add(view);
        }

        layerUI = new TransformUI();
        layerUI.setTransform(transform);
        layer = new JLayer<JComponent>(springPanel, layerUI);

        super.add(layer);

    }

    private void updateConstraints() {
        Spring width = layout.getConstraint(SpringLayout.WIDTH, springPanel);
        Spring height = layout.getConstraint(SpringLayout.HEIGHT, springPanel);

        SpringLayout.Constraints constraints = layout.getConstraints(view);
        constraints.setX(Spring.constant(0));
        constraints.setY(Spring.constant(0));
        constraints.setWidth(Spring.scale(width, (float) (1 / transform.getScaleX())));
        constraints.setHeight(Spring.scale(height, (float) (1 / transform.getScaleX())));
    }

    public void setView(Container view) {
        if (this.view != null) {
            throw new IllegalStateException(
                    this.getClass().getName() + " cannot be shared between multiple containers");
        }

        if (view != null) {
            this.view = view;
            updateConstraints();
            springPanel.add(view);
        } else {
            throw new IllegalArgumentException("Can't set a null view");
        }
    }

    public double getScale() {
        return transform.getScaleX();
    }

    public void zoomIn() {
        setScale(transform.getScaleX() + 0.1);
    }

    public void zoomOut() {
        setScale(transform.getScaleX() - 0.1);
    }

    public void setScale(double scale) {
        if (!(scale < 1)) {
            transform.setToIdentity();
            transform.scale(scale, scale);
            updateConstraints();
            springPanel.updateUI();
        }
    }

    protected Component addToView(Component comp, Object constraints, int index) {
        if (view != null) {
            view.add(comp, constraints, index);
            return comp;
        }

        if (comp instanceof Container) {
            setView((Container) comp);
            return view;
        }

        throw new IllegalStateException("You need to add or set a Container view before adding Components");
    }

    @Override
    public Component add(Component comp) {
        // TODO Auto-generated method stub
        return addToView(comp, null, this.getComponentCount());
    }

    @Override
    public Component add(Component comp, int index) {
        // TODO Auto-generated method stub
        return addToView(comp, null, index);
    }

    @Override
    public void add(Component comp, Object constraints) {
        // TODO Auto-generated method stub
        addToView(comp, constraints, this.getComponentCount());
    }

    @Override
    public void add(Component comp, Object constraints, int index) {
        // TODO Auto-generated method stub
        addToView(comp, constraints, index);
    }

    private void inspectView(Container view) {
        PrintStream ps = null;
        try {
            ps = new PrintStream("C:\\Users\\andrea.maracci\\Documents\\sicraReflectionTemp.txt");
            inspectView(view, 0, ps);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    private static void inspectView(Component component, Integer level, PrintStream ps) {
        for (Integer i = 0; i < level; i++) {
            ps.print("\t");
        }
        ps.print(level + ")");
        ps.println("Inspecting " + component.getClass().getName());

        int accessibleCount = 0;
        if (component.getAccessibleContext() != null) {
            accessibleCount = component.getAccessibleContext().getAccessibleChildrenCount();
            if (accessibleCount > 0) {
                ps.println("*********************************************ACCESSIBLE CONTEXT*********************************************");
                for (int i = 0; i < accessibleCount; i++) {
                    ps.println(i + ") " + component.getAccessibleContext().getAccessibleChild(i).getClass().getName());
                }
                ps.println("************************************************************************************************************");
            }
        }

        if (component instanceof JComponent) {
            JComponent jComponent = ((JComponent)component);

            if (jComponent.getComponentCount() > 0) {
                Component[] children = jComponent.getComponents();
                for (Component child : children) {
                    inspectView(child, ++level, ps);
                }
            }
        }
        --level;
    }
}