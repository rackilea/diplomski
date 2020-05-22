public class MVPPresenter<M, V extends IMVPView<MVPPresenter<M,V>>>
  implements IMVPPresenter<M, V> {

  protected void setView(V view) {
    view.setPresenter(this); // No more error on this line
  }
}