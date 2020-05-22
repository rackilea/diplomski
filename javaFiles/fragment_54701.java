public class JListTest extends JPanel{  
  private static final long serialVersionUID = 1L;

  public JListTest(){
    this.setLayout(new BorderLayout());
    JScrollPane scrollPane = new JScrollPane();
    String[] data = {"the little cat is good", "there is no tomorrow" , "cat is what I need"};
    switchToHtml(data);
    replaceWithImage(data,"cat","cat.png");
    JList<String> list = new JList<String>(data);
    scrollPane.getViewport().add(list);
    this.add(scrollPane,BorderLayout.CENTER);       
  }

  private void replaceWithImage(String[] data, String replace, String image) {
    for (int i = 0; i < data.length; i++) {
        String text = data[i];
        if (text.contains(replace)){
            text = text.replaceAll(replace, "<img src=\"" + JListTest.class.getResource(image) + "\">");
            data[i]=text;
        }           
    }
  }

 private void switchToHtml(String[] data) {
    for (int i = 0; i < data.length; i++) {
        data[i]="<html><body>" + data[i] + "</body></html>";
    }
 }

 public static void main(String[] args) {
    JFrame frame = new JFrame("Test");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(new BorderLayout());
    frame.getContentPane().add(new JListTest(),BorderLayout.CENTER);
    frame.pack();
    frame.setVisible(true);
 }
}