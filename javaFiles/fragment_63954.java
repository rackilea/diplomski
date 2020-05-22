import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import java.awt.event.*;

public class SplitPaneTest2 extends JFrame {

    public SplitPaneTest2() {

        setTitle( "Splits" );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setSize( 400, 400 );

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());

        panel1.add( new JLabel( "Left panel!11111111111111111111" ) );
        JScrollPane scrollPane1 = new JScrollPane(panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());

        panel2.add( new JLabel( "Right Panel11111111111111111111" ) );
        JScrollPane scrollPane2 = new JScrollPane(panel2);

//        scrollPane2.getVerticalScrollBar().setModel(scrollPane1.getVerticalScrollBar().getModel());
//        scrollPane2.getHorizontalScrollBar().setModel(scrollPane1.getHorizontalScrollBar().getModel());
        new ScrollBarSynchronizer(scrollPane1.getHorizontalScrollBar(), scrollPane2.getHorizontalScrollBar());

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane1,
                scrollPane2);
        splitPane.setResizeWeight(0.5);
        add(splitPane);

        setVisible( true );

    }

    public static void main( String[] args ) {
        new SplitPaneTest2();
    }

    static class ScrollBarSynchronizer implements AdjustmentListener
    {
        JScrollBar[] scrollBars;

        public ScrollBarSynchronizer(JScrollBar... scrollBars)
        {
            this.scrollBars = scrollBars;

            for (JScrollBar scrollBar: scrollBars)
                scrollBar.addAdjustmentListener( this );
        }

        @Override
        public void adjustmentValueChanged(AdjustmentEvent e)
        {
            JScrollBar source = (JScrollBar)e.getSource();
            int value = e.getValue();

            for (JScrollBar scrollBar: scrollBars)
            {
                if (scrollBar != source)
                {
                    scrollBar.removeAdjustmentListener( this );
                    scrollBar.setValue( value );
                    scrollBar.addAdjustmentListener( this );
                }
            }
        }
    }

}