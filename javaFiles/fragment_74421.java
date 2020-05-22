public class TimeSet extends Applet{

    public void init () {
        TimeSet();
    }

    public void TimeSet(){
        //set the title
        frame = new JFrame();
        frame.setTitle("2 hour time set");

        //specify what happens when the close button is clicked
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set main panel where all other panels will exist in
        mainPanel = new JPanel(new GridLayout(4,1));
        add(mainPanel);

        timePanel();
        ammountPanel();
        durationPanel();
        buttonSet();

        setVisible(true);
    }
}