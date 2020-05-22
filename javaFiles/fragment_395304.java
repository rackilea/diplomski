public class ListenerClass implements Action{

     @override 
     public void actionPerformed(ActionEvent e) {
         //here retrieve information on which button has generated the event
     }
}

ListenerClass listener = new ListenerClass();
JButton first = new JButton(); 
JButton second = new JButton();
first.addActionListener(listener);
second.addActionListener(listener);