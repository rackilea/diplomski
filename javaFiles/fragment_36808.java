public class TestWindow extends JFrame{

int containerHeigh=300;
int containerWitdh=400;
private JPanel container;
private JPanel westPanel;
private JPanel eastPanel;
private JPanel northPanel;
private JPanel southPanel;
private JPanel centerPanel;
private JScrollPane scroll;

public TestWindow(){
    super("test");
    initComponents();
}

private void initComponents(){
    container=new JPanel();
    westPanel=new JPanel();
    eastPanel=new JPanel();
    northPanel=new JPanel();
    southPanel=new JPanel();
    centerPanel=new JPanel();

    //...fill panels of container
    westPanel.setBackground(new Color(95,183,70));
    eastPanel.setBackground(new Color(0,164,232));
    northPanel.setBackground(new Color(255,255,185));
    southPanel.setBackground(new Color(34,177,76));
    centerPanel.setBackground(new Color(152,114,203));

    scroll=new JScrollPane();
    scroll.setViewportView(container);

    BorderLayout containerLayout=new BorderLayout(containerHeigh, containerWitdh);
    container.setLayout(containerLayout);
    container.add(westPanel, BorderLayout.WEST);
    container.add(eastPanel, BorderLayout.EAST);
    container.add(northPanel, BorderLayout.NORTH);
    container.add(southPanel, BorderLayout.SOUTH);
    container.add(centerPanel, BorderLayout.CENTER);

    add(scroll);
    setVisible(true);
}

public static void main(String...args){
    new TestWindow();
}