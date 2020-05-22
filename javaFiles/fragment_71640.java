public class MyChartpanel extends ChartPanel {
  private JPopupMenu popup;
  public MyChartpanel(Chart2D chart) {
    super(chart);
    MouseListener[] listeners = chart.getMouseListeners();

    for (MouseListener listener : listeners) {
      if (listener instanceof PopupListener) {
        PopupListener popupListener = (PopupListener) listener;
        popup = popupListener.getPopup();
        popup.add(new MyMenuItem());
      }
    }
  }
}