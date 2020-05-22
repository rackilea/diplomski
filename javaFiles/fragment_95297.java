public class ConsoleFrame extends JInternalFrame
{
  JTextArea outArea = new JTextArea(300,300);
  static JInternalFrame cons;
  public ConsoleFrame() 
  {
    JScrollPane pain = new JScrollPane(outArea);
    //pain.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    this.add(pain);
    this.setVisible(true);
    this.setSize(785,255); 
    this.setTitle("Groovy Console");
    this.closable = false;
    this.maximizable = false;
    this.isSelected = true;
    this.resizable = false;
    BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
    Component north = ui.getNorthPane();
    MouseMotionListener[] actions =
    (MouseMotionListener[])north.getListeners(MouseMotionListener.class);

    for (int i = 0; i < actions.length; i++)
    north.removeMouseMotionListener( actions[i] );

    this.setFocusable(false);    
    System.setOut(new PrintStream(new JTextAreaOutputStream(outArea)));
    System.setErr(new PrintStream(new JTextAreaOutputStream(outArea)));
    setConsole(this);
  }


  static public JInternalFrame getConsole(){
      return cons;
  }
  public void setConsole(JInternalFrame console){
      cons = console;
  }
  public class JTextAreaOutputStream extends OutputStream {
    JTextArea ta;

    public JTextAreaOutputStream(JTextArea t) {
      super();
      ta = t;
    }

    public void write(int i) {
      ta.append(Character.toString((char)i));
    }

    public void write(char[] buf, int off, int len) {
      String s = new String(buf, off, len);
      ta.append(s);
    }

  }

}