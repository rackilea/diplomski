import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

public class Main {  
    public static void main(String[] args){

        final JFrame f = new JFrame("Ladder Game");
        Scanner sc = new Scanner(System.in);
        System.out.println("Creating game data...");
        System.out.println("Height: ");

        while (!sc.hasNextInt()) {
            System.out.println("int, please!");
            sc.next();
        }
        final int height = sc.nextInt();

        Grid[]game = new Grid[height];
        for(int L = 0; L < height; L++){
            Grid row = null;
            int i = L+1;
            String s;

            do {
                System.out.println("Length "+i+", please!");
                s = sc.next();
            } while (s.length() != i);

            Element[] line = new Element[s.length()];
            Element single = null;
            String[] temp = null;
            String[] temp2 = new String[s.length()];

            temp = s.split("");
            for( int j = temp2.length; j>0; j--){
                temp2[j-1] = temp[j];
            }

            for (int k = 0 ; k < temp2.length ; k++) {
                if( k == 0 ){
                    single = new Element(temp2[k], 2);
                }
                else{
                    single = new Element(temp2[k], 1);
                }
                line[k] = single;
            }

            row = new Grid(line);
            game[L] = row;
        }

//############################################
//THE GAME STARTS HERE
//############################################
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.ORANGE);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for(int i = 0; i < game.length; i++){
            panel.add(game[i].create(height));
        }

        f.setContentPane(panel);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        boolean end = false;
        boolean word = false;
        String text;

        while( !end ){
            while( !word ){
                text = JOptionPane.showInputDialog("Input word: ");
                for(int i = 1; i< game.length; i++){
                    if(game[i].equalLength(text)){
                        if(game[i].equalValue(text)){
                            word = true;
                            game[i].changeState(3);
                            f.repaint();
                            System.out.println("Word correct !");
                        }
                    }
                }
            }
            word = false;

            for(int i = 0; i < game.length; i++){
                if(game[i].solved()){
                    end = true;
                }
                else {
                    end = false;
                    break;
                }
            }
        }
    }
}


class Grid extends JPanel{
    private Element[]e;
    private Grid[]g;

    public Grid(){}

    public Grid( Element[]elements ){
        e = new Element[elements.length];

        for(int i=0; i< e.length; i++){
            e[i] = elements[i];
        }
    }

    public Grid(Grid[]grid){

        g = new Grid[grid.length];
        for(int i=0; i<g.length; i++){
            g[i] = grid[i];
        }

        Dimension d = new Dimension(600, 600);
        setMinimumSize(d);
        setPreferredSize(new Dimension(d));
        setMaximumSize(d);
    }
    public void changeState(int i){
        for(int j=1; j< e.length; j++){
            e[j].changeState(3);
        }
    }

    public JPanel create(int height){
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(1, height));
        Border border = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.ORANGE);
        panel.setBorder(border);

        for(int j = 0; j < e.length; j++){
            panel.add(e[j].paint());
        }
        for (int j=0; j < height - e.length ; j++)
        {
            JPanel hiddenPanel = new JPanel();
            hiddenPanel.setBackground(Color.ORANGE);
            panel.add(hiddenPanel);
        }
        return panel;
    }

    public boolean equalLength(String s){
        int len = s.length();
        boolean equal =  false;

        for(int j = 0; j < e.length; j++){
            if(e.length == len){
                equal = true;
            }           
        }
        return equal;
    }

    public boolean equalValue(String s){
        int len = s.length();
        boolean equal =  false;
        String[] temp = null;
        String[] temp2 = new String[len];

        temp = s.split("");
        for( int j = len; j>0; j--){
            temp2[j-1] = temp[j];
        }
            for(int j = 0; j < e.length; j++){
                if( e[j].letter().equals(temp2[j]) ){
                    equal = true;
                }
                else {
                    equal = false;
                    break;
                }
            }
            if(equal){
                for(int i = 1; i < e.length; i++){
                    e[i].changeState(3);
                }
            }
        return equal;
    }

    public boolean solved(){
        boolean solved = false;

        if(e.length == 1)
        {
            solved = true;
        }
        else
        {
            for(int j = 0; j < e.length; j++){
            if(e[j].getState() == 3){
                    solved = true;
            }
                else {
                    solved = false;
                }
            }
        }        
        return solved;
    }
}

class Element {

    final int INVISIBLE = 0;
    final int EMPTY = 1;
    final int FIRST_LETTER = 2;
    final int OTHER_LETTER = 3;

    private int state;
    private String letter;
    private JButton button;

    public Element(){      
    }

//empty block    
    public Element(int state){
        this("", 0);
    }

//filled block
    public Element(String s, int state){
        this.state = state;
        this.letter = s;
    }

    public JButton paint(){
        this.button = new JButton();

        changeState();
        button.setSize(20,20);

        return button;
    }

    public void changeState(int s){
        state = s;
        changeState();
    }

    private void changeState()
    {
        if( state == EMPTY ){
            button.setText(" ");
            button.setBackground(Color.WHITE);
        }
        else if ( state == FIRST_LETTER ){
            button.setText(letter);
            button.setBackground(Color.red);
        }
        else {
            button.setText(letter);
            button.setBackground(Color.yellow);
        }
    }

    public void setLetter(String s){
        letter = s;
    }

    public String letter(){
        return letter;
    }

    public int getState(){
        return state;
    }
}