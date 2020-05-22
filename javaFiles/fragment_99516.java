import java.awt.*;

import java.awt.event.*;

import javax.swing.*;


public class ApplicationCentre extends JApplet implements ActionListener {


JButton b1, b2, b3, b4, b5, b6;
JRadioButton rb1 ;
JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;
JTextField t1,t2,t3,t4,t5,t6;
JTextArea ta1, ta2;
JList j1;
JComboBox studentList;
JRadioButton accept[], reject[];
ButtonGroup radioGroup[];  
JPanel deck;
CardLayout cardManager = new CardLayout();
Student s[];
String uniList [] = {"Toronto", "York", "Western", "Brock", "Guelph", "Waterloo",       "McGill", "Concordia", "Laval", "Macmaster"};

public void init(){
s= new Student [100];

Container container = getContentPane();


deck = new JPanel();
cardManager = new CardLayout(); 
deck.setLayout( cardManager ); 

//add panels to deck

deck.add( inputPanel(), "input" );
deck.add( admitPanel(), "admit" );
deck.add( allPanel(), "displayAll" );
deck.add( onePanel(), "displayOne" );

//Left-side Buttons

JPanel P1 = new JPanel();
P1.setLayout (new GridLayout(4, 1));

b1 = new JButton("INPUT");
b1.addActionListener(this);
P1.add(b1);
b2 = new JButton("ADMIT");
b2.addActionListener(this);
P1.add(b2);
b3 = new JButton("DISPLAY ALL");
b3.addActionListener(this);
P1.add(b3);
b4 = new JButton("DISPLAY ONE");
b4.addActionListener(this);    
P1.add(b4);

container.add(P1, BorderLayout.WEST);

// add deck to container


container.add(deck, BorderLayout.CENTER); 


 }

// Input panel

public JPanel inputPanel (){
JPanel P2 = new JPanel();
P2.setLayout (new GridLayout(6,2));

l1 = new JLabel ("Name");    
P2.add(l1);    
t1 = new JTextField (15);

P2.add(t1);    
l2 = new JLabel ("Name of Program");
P2.add(l2);    
t2 = new JTextField ();
P2.add(t2);
l3 = new JLabel ("Average Mark");
P2.add(l3);    
t3 = new JTextField ();
P2.add(t3);
l4 = new JLabel ("Type of postgrad degree");
P2.add(l4);
t4 = new JTextField ();
P2.add(t4);    
l5 = new JLabel ("Universities (select 3)");
P2.add(l5);

j1 = new JList (uniList);
j1.setVisibleRowCount(3);
j1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
P2.add(j1);

b5 = new JButton ("Submit");
P2.add(b5);
l7 = new JLabel ();
P2.add(l7);

return P2;
}

// Admit panel

public JPanel admitPanel(){
JPanel P3 = new JPanel();
P3.setLayout (new BorderLayout());


studentList = new JComboBox(s);
studentList.setMaximumRowCount(8);


P3.add(studentList, BorderLayout.NORTH);


JPanel P3a = new JPanel();
P3a.setLayout (new GridLayout (3,3));
radioGroup = new ButtonGroup[3];
accept = new JRadioButton[3];
reject = new JRadioButton[3];
  for (int j=0; j<3; j++) {
    radioGroup[j] = new ButtonGroup();
    accept[j] = new JRadioButton("Accept", false);
    reject[j] = new JRadioButton("Reject", true);
    radioGroup[j].add(accept[j]);
    radioGroup[j].add(reject[j]);
  }

 l8 = new JLabel ();
 P3a.add(l8);
 P3a.add(accept[0]);
 P3a.add(reject[0]);

 l9 = new JLabel ();
 P3a.add(l9);     
 P3a.add(accept[1]);
 P3a.add(reject[1]);

 l10 = new JLabel ();
 P3a.add(l10);     
 P3a.add(accept[2]);
 P3a.add(reject[2]);

 P3.add(P3a, BorderLayout.CENTER);

 b6 = new JButton ("Submit");
 P3.add(b6, BorderLayout.SOUTH);

 return P3;
}

// DisplayAll panel

public JPanel allPanel(){
 JPanel P4 = new JPanel();

 ta1 = new JTextArea ();
 ta1.setFont(new Font("Serif", Font.ITALIC, 12));
 ta1.setEditable(false);

 P4.add(ta1);

 return P4;
}

//DisplayOne Panel

public JPanel onePanel(){
 JPanel P5 = new JPanel();
 P5.setLayout (new BorderLayout());

 JPanel P5a = new JPanel();
 l11 = new JLabel ("Enter Student's name");
 P5a.add(l11);
 t6 = new JTextField ();
 P5a.add(t6);

 P5.add(P5a, BorderLayout.NORTH);

 ta2 = new JTextArea();
 ta2.setFont(new Font("Arial", Font.PLAIN, 14));
 ta2.setEditable(false);

 P5.add(ta2, BorderLayout.CENTER);


 return P5;
}







public void actionPerformed(ActionEvent e) {

 if ( e.getSource() == b1 )    
     cardManager.show( deck,"input" );
 else if ( e.getSource() == b2 )    
     cardManager.show( deck,"admit" );
 else if ( e.getSource() == b3 )    
     cardManager.show( deck,"displayAll" ); 
 else if ( e.getSource() == b4 )    
     cardManager.show( deck,"displayOne" ); 

}
}

// student class and extensions

abstract class Student {
  private String name, programName, uni1, uni2, uni3;
  public boolean u1a=false;
  public boolean u2a=false;
  public boolean u3a=false;

  public Student (String n, String p, String u1, String u2, String u3){
    setName(n);
    setProgramName(p);
    setUni1(u1);
    setUni2(u2);
    setUni3(u3);
  }

public String getProgramName() {
    return programName;
}

public void setProgramName(String programName) {
    this.programName = programName;
}

public String getUni3() {
    return uni3;
}

public void setUni3(String uni3) {
    this.uni3 = uni3;
}

public String getUni2() {
    return uni2;
}

public void setUni2(String uni2) {
    this.uni2 = uni2;
}

public String getUni1() {
    return uni1;
}

public void setUni1(String uni1) {
    this.uni1 = uni1;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}
}


class Postgrad extends Student{

  private double avgMark;
  private String degree;

  public Postgrad (String n, String p, String u1, String u2, String u3, double avg,    String d){
    super(n, p, u1, u2, u3);
    setAvgMark(avg);
    setDegree(d);
  }

public double getAvgMark() {
    return avgMark;
}

public void setAvgMark(double avgMark) {
    this.avgMark = avgMark;
}

public String getDegree() {
    return degree;
}

public void setDegree(String degree) {
    this.degree = degree;
}

}


class Undergrad extends Student {

  private double avgMark;

  public Undergrad (String n, String p, String u1, String u2, String u3, double   avg){
    super( n, p, u1, u2, u3);
    setAvgMark(avg);
  }

public double getAvgMark() {
    return avgMark;
}

public void setAvgMark(double avgMark) {
    this.avgMark = avgMark;
}
}