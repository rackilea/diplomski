JPanel container1=new JPanel();
container1.setLayout(new BorderLayout());
container1.add(thepanel1);
JPanel container2=new JPanel();
container2.setLayout(new BorderLayout());
container2.add(thepanel2);

public void swap() {
  container2.add(thepanel1);
  container1.add(thepanel2);
  revalidate();
  repaint();
}