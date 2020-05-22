import javax.swing.JTabbedPane;


public class MyTabPanel extends JTabbedPane {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public MyTabPanel() {
        this.addTab("Tab 1", new FirstTabPanel());
        this.addTab("Tab 2", new SecondTabPanel());
    }

}