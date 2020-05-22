public class classB extends JFrame implements ChangeListener {
    private A a;

    public classB(A a) {
      this.a = a;
    }

    public void stateChanged(ChangeEvent e) {
      JSlider source = (JSlider)e.getSource();
      int tmp = source.getValue();
      a.function(tmp);
    }
  }