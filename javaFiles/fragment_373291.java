import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Kviz {

private JFrame okvir;
private JPanel p1,p2,p3;
private JLabel [] nizLabela;
private JRadioButton [] nizRButtona;
private ButtonGroup[] nizGrupa;
private JPanel [] nizPanela;
private CardLayout cl;
private JLabel lb1,lb2;
private JButton btn1,btn2;
private Timer tim;
private int t,s;

public Kviz(){
    pripremiGUI();
}

private void pripremiGUI(){

    okvir=new JFrame();
    okvir.setSize(400, 400);
    okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    okvir.setLocationRelativeTo(null);
    okvir.setLayout(new BorderLayout());

    p1=new JPanel();
    p1.setLayout(new FlowLayout());

    lb1=new JLabel("Dobrodošli u kviz");

    cl=new CardLayout();

    p2=new JPanel();
    p2.setLayout(cl);

    nizPanela = new JPanel[10];

    //Niz panela na kome će se smenjivati pitanja i odgovori
    for(int i=0;i<nizPanela.length;i++){

        nizPanela[i] = new JPanel();
        p2.add(nizPanela[i], String.valueOf(i));
        nizPanela[i].setLayout(new GridLayout(0,1));

    }

    //Niz odgovora

    nizRButtona = new JRadioButton[40];

    for(int i=0;i<nizRButtona.length;i++){
        nizRButtona[i] = new JRadioButton();

        switch(i){
            case 0:nizRButtona[i].setText("Mesopotamiji");
                break;
            case 1:nizRButtona[i].setText("Grčkoj");
                break;
            case 2:nizRButtona[i].setText("Kini");
                break;
            case 3:nizRButtona[i].setText("Egiptu");
                break;
            case 4:nizRButtona[i].setText("Kinšasa");
                break;
            case 5:nizRButtona[i].setText("Lagos");
                break;
            case 6:nizRButtona[i].setText("Ulan Bator");
                break;
            case 7:nizRButtona[i].setText("Abu Dabi");
                break;
            case 8:nizRButtona[i].setText("Velikoj Britaniji");
                break;
            case 9:nizRButtona[i].setText("Norveškoj");
                break;
            case 10:nizRButtona[i].setText("SAD");
                break;
            case 11:nizRButtona[i].setText("Danskoj");
                break;
            case 12:nizRButtona[i].setText("Step mom");
                break;
            case 13:nizRButtona[i].setText("Runaway Bride");
                break;
            case 14:nizRButtona[i].setText("Grease");
                break;
            case 15:nizRButtona[i].setText("Nothing Hill");
                break;
            case 16:nizRButtona[i].setText("Neil Armstrong");
                break;
            case 17:nizRButtona[i].setText("John Lenon");
                break;
            case 18:nizRButtona[i].setText("Martin Luter King");
                break;
            case 19:nizRButtona[i].setText("Winston Churchill");
                break;
            case 20:nizRButtona[i].setText("Meka");
                break;
            case 21:nizRButtona[i].setText("Medina");
                break;
            case 22:nizRButtona[i].setText("Dubai");
                break;
            case 23:nizRButtona[i].setText("Rijad");
                break;
            case 24:nizRButtona[i].setText("Španije");
                break;
            case 25:nizRButtona[i].setText("Venecije");
                break;
            case 26:nizRButtona[i].setText("Portugala");
                break;
            case 27:nizRButtona[i].setText("Đenove");
                break;
            case 28:nizRButtona[i].setText("Holokaust");
                break;
            case 29:nizRButtona[i].setText("Perl Harbour");
                break;
            case 30:nizRButtona[i].setText("Napad na Francusku");
                break;
            case 31:nizRButtona[i].setText("Blitzkrieg na Poljsku");
                break;
            case 32:nizRButtona[i].setText("Bon");
                break;
            case 33:nizRButtona[i].setText("Minhen");
                break;
            case 34:nizRButtona[i].setText("Lajpcig");
                break;
            case 35:nizRButtona[i].setText("Hamburg");
                break;
            case 36:nizRButtona[i].setText("Čile");
                break;
            case 37:nizRButtona[i].setText("Istočni Timor");
                break;
            case 38:nizRButtona[i].setText("Portugal");
                break;
            case 39:nizRButtona[i].setText("Brazil");
                break;

        }
    }

    //Niz button grupa i dodavanje komponenti u njega
    nizGrupa=new ButtonGroup[10];

    int j=0;
    for(int i=0;i<nizGrupa.length;i++){

    nizGrupa[i] = new ButtonGroup();

    nizGrupa[i].add(nizRButtona[j]);
    nizGrupa[i].add(nizRButtona[j+1]);
    nizGrupa[i].add(nizRButtona[j+2]);
    nizGrupa[i].add(nizRButtona[j+3]);

    j+=4;
    }

    //Niz pitanja
    nizLabela = new JLabel[10];

    for(int i=0;i<nizLabela.length;i++){
        nizLabela[i] = new JLabel();
        switch(i){
            case 0:nizLabela[i].setText("U kojoj zemlji su rođene Olimpijske igre");
                break;
            case 1:nizLabela[i].setText("Koji je glavni grad Nigerije");
                break;
            case 2:nizLabela[i].setText("Kojoj državi pripada Grenland");
                break;
            case 3:nizLabela[i].setText("Osim filma \"Pretty Women\" u kojem filmu zajedno glume Julia Roberts i Richard Gere");
                break;
            case 4:nizLabela[i].setText("Kako se zove prvi čovek koji je sleteo na mesec");
                break;
            case 5:nizLabela[i].setText("Glavni grad Saudijske Arabije");
                break;
            case 6:nizLabela[i].setText("Kristofer Kolumob je iz");
                break;
            case 7:nizLabela[i].setText("Koji događaj je naveo SAD da se uključe u rat");
                break;
            case 8:nizLabela[i].setText("Koji je grad bio glavni pri ujedinjenju Nemačke");
                break;
            case 9:nizLabela[i].setText("U kojoj zemlji je bio na vlasti diktator Salazar");
                break;
        }
    }

    p3=new JPanel();
    p3.setLayout(new FlowLayout());

    //Menja panele sa pitanjima i odgovorima
    btn1=new JButton("Sledeće pitanje");
    btn1.setEnabled(false);
    btn1.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            cl.next(p2);
            btn1.setEnabled(false);
            btn2.setEnabled(true);
            t=10;
            lb2.setText(String.valueOf(t));
            tim.start();
            btn1.setText("Sledeće pitanje");
        }
    });

    //Proverava da li su odgovori tačni
    btn2=new JButton("Odgovori");
    btn2.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            tim.stop();
            btn1.setEnabled(true);

            if(nizRButtona[1].isSelected()
                ||nizRButtona[5].isSelected()
                ||nizRButtona[11].isSelected()
                ||nizRButtona[13].isSelected()
                ||nizRButtona[16].isSelected()
                ||nizRButtona[23].isSelected()
                ||nizRButtona[27].isSelected()
                ||nizRButtona[29].isSelected()
                ||nizRButtona[32].isSelected()){
                s+=10;
                JOptionPane.showMessageDialog(null, "Correct");
            } else if(nizRButtona[36].isSelected()){
                s+=10;
                JOptionPane.showMessageDialog(null, "Correct, points earned: " + s);
                btn1.setText("Započni opet igru");
            }else if(nizRButtona[33].isSelected()
                    ||nizRButtona[34].isSelected()
                    ||nizRButtona[35].isSelected()){
                JOptionPane.showMessageDialog(null, "Incorrect, points earned " + s);
                btn1.setText("Započni opet igru");
            }else{
                JOptionPane.showMessageDialog(null, "Incorrect");
            }
            for (int i = 0; i < 10; i++) {
                nizGrupa[i].clearSelection();
            }
        }

    });

    t=10;

    //Tajmer
    lb2=new JLabel("10");
    tim=new Timer(1000,new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            if(t>0){
            t--;
            lb2.setText(String.valueOf(t));
            }else{
                tim.stop();
                JOptionPane.showMessageDialog(null, "Vreme je isteklo");
                btn2.setEnabled(false); 
                btn1.setEnabled(true);
            }
        }
    });
}

private void pokreniGUI(){
    p1.add(lb1);

    p3.add(btn1);
    p3.add(btn2);
    p3.add(lb2);

    int q=0;
    for(int w=0;w<10;w++){

    //nizGrupa[w] = new ButtonGroup();

    nizPanela[w].add(nizLabela[w]);
    nizPanela[w].add(nizRButtona[q]);
    nizPanela[w].add(nizRButtona[q+1]);
    nizPanela[w].add(nizRButtona[q+2]);
    nizPanela[w].add(nizRButtona[q+3]);

    q+=4;
    }

    okvir.add(p1,BorderLayout.NORTH);
    okvir.add(p2,BorderLayout.CENTER);
    okvir.add(p3,BorderLayout.SOUTH);

    cl.show(p2, "0");

    tim.start();
    okvir.setVisible(true);
}

public static void main(String[] args) {
    Kviz pokreni=new Kviz();
    pokreni.pokreniGUI();

}
}