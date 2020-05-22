public class TicTacToe extends JFrame {
  private boolean reset;
  private int i=-1;
  private String one;
  private String two;
  private String three;
  private String four;
  private String five;
  private String six;
  private String seven;
  private String eight;
  private String nine;
  private boolean x;
  private boolean o;
  private boolean cat;

  public static void main(String[] args) {
   new TicTacToe();
  }

  public TicTacToe() {
    super.setTitle("Tic Tac Toe");
    super.setSize(800, 800);
    super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    buildPanel();
    super.setVisible(true);
  }

  public void buildPanel() {
    one="";
    two="";
    three="";
    four="";
    five="";
    six="";
    seven="";
    eight="";
    nine="";
    Font f = new Font("Times New Roman", Font.BOLD, 75);
    GridLayout g = new GridLayout(3, 3);
    JPanel p = new JPanel();
    p.setLayout(g);
    JButton[] buttons = new JButton[9];
    buttons[0] = new JButton("");
    p.add(buttons[0]);
    buttons[1] = new JButton("");
    p.add(buttons[1]);
    buttons[2] = new JButton("");
    p.add(buttons[2]);
    buttons[3] = new JButton("");
    p.add(buttons[3]);
    buttons[4] = new JButton("");
    p.add(buttons[4]);
    buttons[5] = new JButton("");
    p.add(buttons[5]);
    buttons[6] = new JButton("");
    p.add(buttons[6]);
    buttons[7] = new JButton("");
    p.add(buttons[7]);
    buttons[8] = new JButton("");
    p.add(buttons[8]);

    add(p);

   buttons[0].addActionListener(event -> {
     i++;
     one=buttons[0].getText();
     if (!one.equals("O")&&!one.equals("X")){
       buttons[0].setText("O");
     if (i % 2 == 0) {
       buttons[0].setText("X");}
       buttons[0].setFont(f);
       one=buttons[0].getText();
       check();
     }

     if (reset){
       buttons[0].setText("");
       buttons[1].setText("");
       buttons[2].setText("");
       buttons[3].setText("");
       buttons[4].setText("");
       buttons[5].setText("");
       buttons[6].setText("");
       buttons[7].setText("");
       buttons[8].setText("");
       reset=false;
     }
   });

   buttons[1].addActionListener(event-> {
     i++;
     two=buttons[1].getText();
     if (!two.equals("O")&&!two.equals("X")){
      buttons[1].setText("O");
     if (i % 2 == 0) {
       buttons[1].setText("X");}
       buttons[1].setFont(f);
       two=buttons[1].getText();
       check();
     }
     if (reset){
       buttons[0].setText("");
       buttons[1].setText("");
       buttons[2].setText("");
       buttons[3].setText("");
       buttons[4].setText("");
       buttons[5].setText("");
       buttons[6].setText("");
       buttons[7].setText("");
       buttons[8].setText("");
       reset=false;
       }
   });
    buttons[2].addActionListener(event-> {
      i++;
      three=buttons[2].getText();
      if (!three.equals("O")&&!three.equals("X")){
      buttons[2].setText("O");
      if (i % 2 == 0) {
        buttons[2].setText("X");}
        buttons[2].setFont(f);
      }
      three=buttons[2].getText();
      check();
      if (reset){
        buttons[0].setText("");
        buttons[1].setText("");
        buttons[2].setText("");
        buttons[3].setText("");
        buttons[4].setText("");
        buttons[5].setText("");
        buttons[6].setText("");
        buttons[7].setText("");
        buttons[8].setText("");
        reset=false;
        }
    });
    buttons[3].addActionListener(event-> {
      i++;
      four=buttons[3].getText();
      if (!four.equals("O")&&!four.equals("X")){
      buttons[3].setText("O");
      if (i % 2 == 0) {
        buttons[3].setText("X");}
        buttons[3].setFont(f);
        four=buttons[3].getText();
        check();
      }
      if (reset){
        buttons[0].setText("");
        buttons[1].setText("");
        buttons[2].setText("");
        buttons[3].setText("");
        buttons[4].setText("");
        buttons[5].setText("");
        buttons[6].setText("");
        buttons[7].setText("");
        buttons[8].setText("");
        reset=false;
      }
    });
    buttons[4].addActionListener(event-> {
      i++;
      five=buttons[4].getText();
      if (!five.equals("O")&&!five.equals("X")){
      buttons[4].setText("O");
      if (i % 2 == 0) {
        buttons[4].setText("X");}
        buttons[4].setFont(f);
        five=buttons[4].getText();
        check();
      }
      if (reset){
        buttons[0].setText("");
        buttons[1].setText("");
        buttons[2].setText("");
        buttons[3].setText("");
        buttons[4].setText("");
        buttons[5].setText("");
        buttons[6].setText("");
        buttons[7].setText("");
        buttons[8].setText("");
        reset=false;
        }
    });
    buttons[5].addActionListener(event-> {
      i++;
      six=buttons[5].getText();
      if (!six.equals("O")&&!six.equals("X")){
      buttons[5].setText("O");
      if (i % 2 == 0) {
        buttons[5].setText("X");}
        buttons[5].setFont(f);
        six=buttons[5].getText();
        check();
      }
      if (reset){
        buttons[0].setText("");
        buttons[1].setText("");
        buttons[2].setText("");
        buttons[3].setText("");
        buttons[4].setText("");
        buttons[5].setText("");
        buttons[6].setText("");
        buttons[7].setText("");
        buttons[8].setText("");
        reset=false;
        }
    });
    buttons[6].addActionListener(event-> {
      i++;
      seven=buttons[6].getText();
      if (!seven.equals("O")&&!seven.equals("X")){
      buttons[6].setText("O");
      if (i % 2 == 0) {
        buttons[6].setText("X");}
        buttons[6].setFont(f);
        seven=buttons[6].getText();
        check();
      }
      if (reset){
        buttons[0].setText("");
        buttons[1].setText("");
        buttons[2].setText("");
        buttons[3].setText("");
        buttons[4].setText("");
        buttons[5].setText("");
        buttons[6].setText("");
        buttons[7].setText("");
        buttons[8].setText("");
        reset=false;
        }
    });
    buttons[7].addActionListener(event-> {
      i++;
      eight=buttons[7].getText();
      if (!eight.equals("O")&&!eight.equals("X")){
      buttons[7].setText("O");
      if (i % 2 == 0) {
        buttons[7].setText("X");}
        buttons[7].setFont(f);
        eight=buttons[7].getText();
        check();
      }
      if (reset){
        buttons[0].setText("");
        buttons[1].setText("");
        buttons[2].setText("");
        buttons[3].setText("");
        buttons[4].setText("");
        buttons[5].setText("");
        buttons[6].setText("");
        buttons[7].setText("");
        buttons[8].setText("");
        reset=false;
        }
    });
    buttons[8].addActionListener(event-> {
      i++;
      nine=buttons[8].getText();
      if (!nine.equals("O")&&!nine.equals("X")){
      buttons[8].setText("O");
      if (i % 2 == 0) {
        buttons[8].setText("X");}
        buttons[8].setFont(f);
        nine=buttons[8].getText();
        check();
      }
      if (reset){
        buttons[0].setText("");
        buttons[1].setText("");
        buttons[2].setText("");
        buttons[3].setText("");
        buttons[4].setText("");
        buttons[5].setText("");
        buttons[6].setText("");
        buttons[7].setText("");
        buttons[8].setText("");
        reset=false;
      }
    });
    }

    public void check (){
      if (one.equals("O") && two.equals("O") && three.equals("O")){
        o=true;
      }
      else if (four.equals("O") && five.equals("O") && six.equals("O")){
        o=true;
      }
      else if (seven.equals("O") && eight.equals("O") && nine.equals("O")){
        o=true;
      }
      else if (one.equals("O") && five.equals("O") && nine.equals("O")){
        o=true;
      }
      else if (three.equals("O") && five.equals("O") && seven.equals("O")){
        o=true;
      }
      else if (one.equals("X") && two.equals("X") && three.equals("X")){
        x=true;
      }
      else if (four.equals("X") && five.equals("X") && six.equals("X")){
        x=true;
      }
      else if (seven.equals("X") && eight.equals("X") && nine.equals("X")){
        x=true;
      }
      else if (one.equals("X") && five.equals("X") && nine.equals("X")){
        x=true;
      }
      else if (three.equals("X") && five.equals("X") && seven.equals("X")){
        x=true;
      }
      else if (!o&&!x&&!one.equals("")&&!two.equals("")&&!three.equals("")&&!four.equals("")&&!five.equals("")&&!six.equals("")&&!seven.equals("")&&!eight.equals("")&&!nine.equals("")){
        cat=true;
      }
      if (x){
        JOptionPane.showMessageDialog(null,"X wins!\nResetting...");
        clear();
        reset=true;
      } else if (o){
        JOptionPane.showMessageDialog(null,"O wins!\nResetting...");
        clear();
        reset=true;
      } else if (cat){
        JOptionPane.showMessageDialog(null,"Cat's game\nResetting...");
        clear();
        reset=true;
      }
    }
    public void clear(){
      one="";
      two="";
      three="";
      four="";
      five="";
      six="";
      seven="";
      eight="";
      nine="";
      o=false;
      x=false;
      cat=false;
      i=-1;
    }
}