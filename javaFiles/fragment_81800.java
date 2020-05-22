package it.bracco23.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

// Improved version of http://java-sl.com/tip_adapt_label_font_size.html

public class JAdaptiveLabel extends JLabel {

    private Graphics g;
    private boolean init = false;

    public JAdaptiveLabel(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
        init();
    }

    public JAdaptiveLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
        init();
    }

    public JAdaptiveLabel(String text) {
        super(text);
        init();
    }

    public JAdaptiveLabel(Icon image, int horizontalAlignment) {
        super(image, horizontalAlignment);
        init();
    }

    public JAdaptiveLabel(Icon image) {
        super(image);
        init();
    }

    public JAdaptiveLabel() {
        init();
    }



    protected void init() {
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                adaptLabelFont(JAdaptiveLabel.this);
            }
        });
        init = true;
    }

   protected void adaptLabelFont(JLabel l) {
        if (g==null) {
            return;
        }

        Rectangle r  = l.getBounds();
        Insets ins = l.getInsets();
        r.x          = 0;    
        r.y          = 0;    
        Font f       = l.getFont();
        Dimension dim = getTextSize(l, f);
        //0.9f is a scale factor to don't let the text take too much space
        //without it will work, but the text may appear to close to the border
        float xFactor = ((r.width - ins.left - ins.right) * 0.9f) / dim.width;
        float yFactor = ((r.height - ins.top - ins.bottom) * 0.9f) / dim.height;

        /*the next lines assure the scaling factors are not zero (can happen)
        and are different enough from 1. Without this last check, it might happen
        that the font starts to cycle between two sizes. */
        xFactor = (xFactor != 0 && Math.abs(xFactor - 1)>0.1) ? xFactor : 1;
        yFactor = (yFactor != 0 && Math.abs(xFactor - 1)>0.1) ? yFactor : 1;
        float fontSize = f.getSize() * Math.min(xFactor, yFactor);

        setFont(f.deriveFont(f.getStyle(), fontSize));
        repaint();
    }

    private Dimension getTextSize(JLabel l, Font f) {
        Dimension size  = new Dimension();
        FontMetrics fm  = g.getFontMetrics(f);
        size.width      = fm.stringWidth(l.getText());
        size.height     = fm.getHeight();
        return size;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.g=g;
    }

      @Override
    public void setText(String text) {
        super.setText(text);
        if(init){
           adaptLabelFont(this);
        }
    }

}