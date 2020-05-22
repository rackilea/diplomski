class MyPanel extends JPanel
{
  ImageIcon icon;
  JTextArea textArea;

  MyPanel(ImageIcon icon, String text)
  {
    this.icon = icon;
    this.setPreferredSize(/*max size of your panel */)
    textArea = new JTextArea(10, 50);
    textArea.append(text);

    //the default manager will be a flow layout for single jpanels
    this.add(icon);
    JScrollPane sp = new JScrollPane(textArea);
    sp.setPreferredSize(new Dimension(/* size of your text label */));
    this.add(new JScrollPtextArea);
  }
}

class MyContainer extends JFrame
{
  JPanel container;
  JScrollPane spContainer;

  MyContainer()
  {
     container = new JPanel()
     container.setGridLayout(100,1); //100 elements max
     spContainer = new JScrollPane(container);
     spContainer.setPreferredSize(/* max size of whole thing */)
     this.add(spContainer);
     pack();
  }

  void addElement(MyPanel panel)
  {
    container.add(panel);
    this.pack();
  }
}