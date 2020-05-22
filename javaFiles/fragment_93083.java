import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ManyViewsTest
{   
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {               
                View v1 = new View();
                View v2 = new View();
                View v3 = new View();
                View v4 = new View();               
                View v5 = new View();               
                JPanel contentPane = new JPanel();
                contentPane.add(v1);
                contentPane.add(v2);
                contentPane.add(v3);
                contentPane.add(v4);
                contentPane.add(v5);
                JFrame f = new JFrame();
                f.setContentPane(contentPane);
                f.setSize(800, 600);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Controller c = new Controller(f);
                f.setVisible(true);
            }
        });
    }
}

class Controller 
{
    private List<View> views;

    public Controller(JFrame f)
    {
        this.views = new ArrayList<View>();
        f.addMouseListener(mL);
        for(Component c: f.getContentPane().getComponents())
        {
            if(c instanceof View)
                views.add((View)c);
        }
    }

    public void updateView(String text)
    {
        for(View v: views)
            v.setLabelText(text);
    }

    private MouseListener mL = new MouseAdapter() 
    {
        int pressCounter = 0;
        @Override
        public void mousePressed(MouseEvent e)
        {
            super.mousePressed(e);
            updateView("mousePressed, pressCounter="+(++pressCounter));
        }                                       
    };
}

class View extends JPanel
{
    private static final long serialVersionUID = 1L;
    private JLabel label;
    public View()
    {
        this.label = new JLabel("Initialized");
        label.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        add(label);
    }
    public void setLabelText(String text)
    {
        label.setText(text);
    }
}