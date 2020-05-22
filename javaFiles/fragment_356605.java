//somewhere at the top of your class
private final Map<String, JButton> myButtonMap = new HashMap<>();

public void createButton(Container parent, String btnName) {
   JButton btn = new JButton("xyz");
   btn.setName(btnName);
   btn.addActionListner(new ActionListner() {
      //code
   }
   parent.add(btn);
   myButtonMap.put(btnName, btn);
 }