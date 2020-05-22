public class ChangeTextMouseEvent extends Frame
{
static JButton btn;
public ChangeTextMouseEvent()
{
    setTitle("ChangeText");
    btn = new JButton("SSS");
    add(btn);
    setVisible(true);
    setBounds(0, 0, 100, 100);
}
public static void main(String[] args)
{
    ChangeTextMouseEvent frame = new ChangeTextMouseEvent();
    btn.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseExited(MouseEvent e)
        {
            btn.setText("Bye");
        }
        @Override
        public void mouseEntered(MouseEvent e)
        {
            btn.setText("Hi");
        }
    });
}
}