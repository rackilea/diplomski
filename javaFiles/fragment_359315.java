import javax.swing.JSlider;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class MyJSlider extends JSlider
{
    private boolean isEnabled = true;

    public void setEnabled(boolean isEnabled)
    {
        this.isEnabled = isEnabled;
    }

    @Override
    public synchronized void addMouseListener(final MouseListener delegate)
    {
        super.addMouseListener(
            new MouseListener() {
                @Override
                public void mouseClicked(final MouseEvent e) {
                    delegate.mouseClicked(e);
                }

                @Override
                public void mousePressed(final MouseEvent e) {
                    delegate.mousePressed(e);
                }

                @Override
                public void mouseReleased(final MouseEvent e) {
                    if (isEnabled) {
                        delegate.mouseReleased(e);
                    }
                }

                @Override
                public void mouseEntered(final MouseEvent e) {
                    delegate.mouseEntered(e);
                }

                @Override
                public void mouseExited(final MouseEvent e) {
                    delegate.mouseExited(e);
                }
            }
        );
    }
}