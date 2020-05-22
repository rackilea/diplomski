package dataGraph;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;

public class DataEntryGUI extends JFrame implements ActionListener {

    public static ArrayList<String> x;  //This should be figured out by
    public static ArrayList<String> y;  //the OP. Encapsulation and
                                        //decoupling is a different matter.

    private Button btnAdd;
    private Button btnGraph;
    private Label lbl;
    private Label lbl2;
    private TextField xInt;
    private TextField yInt;


    public DataEntryGUI() {
        setTitle("Data entry");
        setSize(250, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        lbl = new Label("x");

        lbl2 = new Label("y");

        // text fields
        xInt = new TextField();

        yInt = new TextField();
        x = new ArrayList<String>();
        y = new ArrayList<String>();

        // add button
        btnAdd = new Button("Add another");
        // btnAdd.setPreferredSize(new Dimension(70,30));
        btnAdd.addActionListener(this);
        btnGraph = new Button("Make Graph");
        btnGraph.addActionListener(this);
        add(lbl);
        add(xInt);
        add(lbl2);
        add(yInt);
        add(btnAdd);
        add(btnGraph);
        setLayout(new FlowLayout());
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        // System.out.println("boogers");

        if (e.getSource() == btnAdd) {
            //xInt.getText();

            x.add(xInt.getText());
            y.add(yInt.getText());
            xInt.setText("");
            yInt.setText("");

        } else {
            paintGraph();
        }
    }

    private void paintGraph() {
        JFrame graphFrame = new JFrame();
        GraphGUI graph = new GraphGUI();
        graphFrame.getContentPane().add(graph);

        graphFrame.setTitle("Data Graph");
        graphFrame.setSize(500, 500);
        graphFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        graphFrame.setResizable(false);
        graphFrame.setVisible(true);

    }

}