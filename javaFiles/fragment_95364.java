import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class FillBoxLayoutPanel extends JPanel {

    public static final int X_AXIS = BoxLayout.X_AXIS;
    public static final int Y_AXIS = BoxLayout.Y_AXIS;

    private final List<Component> components;

    private final int direction;
    private boolean layoutSet;

    public FillBoxLayoutPanel(int direction) {
        components = new ArrayList<>();
        this.direction = direction;
        setLayout(new BoxLayout(this, direction));
        layoutSet = true;
        addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent ce) {
                adjustComponents();
            }

            @Override
            public void componentMoved(ComponentEvent ce) {
            }

            @Override
            public void componentShown(ComponentEvent ce) {
            }

            @Override
            public void componentHidden(ComponentEvent ce) {
            }
        });
    }

    @Override
    public void setLayout(LayoutManager mgr) {
        if (layoutSet) {
            throw new UnsupportedOperationException("FillPanel's layout manager cannot be changed.");
        } else {
            super.setLayout(mgr);
        }
    }

    @Override
    public Component add(Component comp) {
        comp = super.add(comp);
        components.add(comp);
        return comp;
    }

    @Override
    public Component add(Component comp, int i) {
        comp = super.add(comp, i);
        components.add(i, comp);
        return comp;
    }

    private void adjustComponents() {            
        if (!components.isEmpty()) {
            int size = direction == X_AXIS ? getWidth() : getHeight();
            int baseComponentSize = size / components.size();
            int remainder = size % components.size();

            for (int i = 0; i < components.size(); i++) {
                int componentSize = baseComponentSize;
                if (i < remainder) {
                    componentSize++;
                }
                Dimension dimension;
                if (direction == X_AXIS) {
                    dimension = new Dimension(componentSize, components.get(i).getHeight());
                } else {                    
                    dimension = new Dimension(components.get(i).getWidth(), componentSize);
                }
                components.get(i).setMaximumSize(dimension);
            }
            revalidate();
        }
    }

}