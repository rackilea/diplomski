public class PanelFurniture extends JPanel
{

    JLabel label;
    JButton a,b;
    JPanel centerPanel, eastPanel;

    public void init()
    {
        this.setLayout(new BorderLayout());

        centerPanel = new JPanel();
        //centerPanel.setLayout();

        this.add(centerPanel, BorderLayout.CENTER);


        eastPanel = new JPanel(new GridLayout(1,3));

        label = new JLabel();
        b = new JButton("Move");
        eastPanel.add(b);
        eastPanel.add(label);
        a = new JButton("ee");
        eastPanel.add(a);

        this.add(eastPanel, BorderLayout.EAST);
    }
}