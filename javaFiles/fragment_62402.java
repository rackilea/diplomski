abstract class BaseActivity<E extends Activity> {
  public E activity;
  public BaseActivity(E activity){
    this.activity = activity; 
  } 
// ...
}