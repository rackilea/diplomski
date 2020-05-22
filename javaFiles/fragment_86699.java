private Vector<Integer> data;
public int x;
int pt1;
public int pt2;
private Rectangle Node;
private boolean f1, f2 = false;
private JButton linkButton, nodeButton;

Nodes ()
{
    JFrame F = new JFrame ("Add Node / Add Link");
    Vector nodeVector, linkVector;
    nodeVector = new Vector ();
    linkVector = new Vector ();
    data = new Vector <Integer> ();
    F.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    F.setVisible (true);
    F.setSize (500, 500);

    JPanel p1 = new JPanel ();
    linkButton = new JButton ("Add Link");
    nodeButton = new JButton ("Add Node");
    linkButton.addActionListener (this);
    nodeButton.addActionListener (this);
    addMouseListener (this);
    addMouseMotionListener (this);
    p1.add (linkButton);
    p1.add (nodeButton);
    F.add (p1, BorderLayout.SOUTH);
    F.add (this, BorderLayout.CENTER);
    setBackground (Color.WHITE);
}