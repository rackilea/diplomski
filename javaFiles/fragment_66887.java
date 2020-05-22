public abstract class AbstractScreen implements IActivity {

protected Response response;
protected FragmentActivity activity;
private CustomProgressDialog progress;

public AbstractScreen(FragmentActivity activity) {
this.activity = activity;
}

public abstract void loadScreen();

@Override
public void preExecution() {
// TODO Auto-generated method stub

}

@Override
public void postExecution(Response response) {
// TODO Auto-generated method stub

}

 public void showProgressBar() {


 progress = new CustomProgressDialog(activity);
 progress.show();
 }

 public void closeProgress() {
 progress.dismiss();
 }

 public FragmentActivity getActivity() {
 return activity;
 }

 private class CustomProgressDialog extends Dialog {

 private Context context;

 public CustomProgressDialog(Context context) {
 super(context);
 this.context = context;
 loadScreen();
 }

 public void loadScreen() {

 requestWindowFeature(Window.FEATURE_NO_TITLE);
 setContentView(R.layout.progress);
 setCancelable(false);

 }

 }
 }