import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CLayout {
    //1) create the Frame
    JFrame MainWindow = new JFrame("Finestra di Gioco"); 
    //2) create as many JPanels as messages + levels, but...
    JPanel panelCont = new JPanel(); //...the first one needs to contain them all
    JPanel FinestraLancio = new JPanel(); 
    JPanel Livello1 = new JPanel(); 
    JPanel Livello2 = new JPanel(); 
    //3) create the buttons to switch among panels
    JButton OpenLevel1 = new JButton("Open Level 1"); 
    JButton CompleteLevel1 = new JButton("Complete Level 1"); 
    JButton OpenLevel2 = new JButton("Open Level 2"); 
    JButton CompleteLevel2 = new JButton("Complete Level 2"); 

    //4) create an instance of the card Layout method
    CardLayout cl = new CardLayout(); 

    //5) create the constructor
    public CLayout(){
        //5.a) assign the instance of the card Layout to the container panel
        panelCont.setLayout(cl);

        //5.b) create the windows insert the buttons, assign the actions
        FinestraLancio.add(OpenLevel1); 
        FinestraLancio.add(OpenLevel2);
        OpenLevel2.setVisible(false);
        Livello1.add(CompleteLevel1); 
        Livello2.add(CompleteLevel2); 

        Livello1.setBackground(Color.yellow);
        Livello2.setBackground(Color.blue);

        OpenLevel1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent OpenLevel1){
                cl.show(panelCont, "2"); //this "2" is the position indicator, 
                                        //we'll discuss it at 5c
            }
        });

        OpenLevel2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent OpenLevel2){
                cl.show(panelCont, "3");
            }
        });

        CompleteLevel1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent CompleteLevel1){
                OpenLevel2.setVisible(true);
                cl.show(panelCont, "1");
            }
        });
        CompleteLevel2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent CompleteLevel2){
                OpenLevel2.setVisible(false);
                cl.show(panelCont, "1");
            }
        });        
        //5.c) now put the elements in the container panel, and add the name of 
        //the element and the position indicator you will need that position 
        //indicator when you want to call that specific window
        panelCont.add(FinestraLancio, "1"); //"1" is the position indicator
        panelCont.add(Livello1, "2"); 
        panelCont.add(Livello2, "3"); 

        //now indicate that the instance of the cardlayout has the container as 
        //its main panel and inside the container the first panel to be displayed 
        //is the one with the position indicator "1", i.e. the LaunchWindow
        cl.show(panelCont, "1");

        //create the main window
        MainWindow.add(panelCont); 
        MainWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        MainWindow.setSize(400, 400);
        MainWindow.setVisible(true);

    }

    public static void main (String[]args){
        SwingUtilities.invokeLater
        (new Runnable(){
            @Override
            public void run(){
                new CLayout(); 
            }
        }); 
    }

}