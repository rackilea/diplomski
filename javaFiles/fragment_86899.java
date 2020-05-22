MyFrame extends JFrame {

etc...

 Container container = getContentPane();
 container.setName("main.container");
 container.setLayout(new BorderLayout());

 container.add(new MyCanvasPanel(), BorderLayout.CENTER);

}  

// this could probably be added to the palete
public class MyCanvasPanel extends JPanel {

    SimpleUniverse su;
    Canvas3D canvas3D;

  public MyCanvasPanel() {
        canvas3D = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
        add("Center", canvas3D);
        su = new SimpleUniverse(canvas3D);
  }

}