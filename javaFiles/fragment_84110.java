public class Guess extends Applet implements ActionListener
{
  util u = new util(); //Utility class
  int answer = u.rand(1,100); //Randomize answer
  String ansWord = Integer.toString(answer); //Convert Integer to String
  int winloss = 1; //Set winloss to display startup message
  TextField input; //Declare TextField
  boolean pizza,blazeIt; //Easter Eggs
  String response; //Declare Strings
  public void init()
  {
    input = new TextField(5);
    add(input);
    input.addActionListener(this);
  }

  public void paint(Graphics g)
  {
    g.drawString(""+winloss,10,20);
    switch(winloss)
    {
      case 1:g.drawString("Guess What Number I Am Thinking Of",getWidth()/2-100,50);
        break;
      case 2:g.drawString("How did you know?!?!?!",getWidth()/2-50,50);
        break;
      case 3:g.drawString("Nope",getWidth()/2-5,50);
        break;
      case 4:pizza = true;
        break;
      case 5:blazeIt = true;
        break;
      default:g.drawString("Broken",10,10);
        break;
    }
    easterCheck(g);
  }

  public void actionPerformed(ActionEvent e)
  {
    response = String.valueOf(input.getText());
    if(response.equals(ansWord))
    {
      winloss = 2;
    } else if (response.equals("420")) {
      winloss = 5;
    } else if (response.equals("Pizza")) {
      winloss = 4;
    } else {
      winloss = 3;
    }
    repaint();
  }

  public void easterCheck(Graphics g)
  {
    if(pizza)
    {
      g.drawString("Delicious!",10,getHeight()-10);
    }
    if(blazeIt)
    {
      g.drawString("Blaze it!",10,getHeight()-20);
    }
  }

}