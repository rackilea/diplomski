public class CustomView extends LinearLayout {
 private Context context;
 public CustomView(Context context) {
   super(context);//ADD THIS
   this.context = context;
 }
 ..
 public void init() {
   //modified here.
    inflate(context, R.layout.xxxxxxxxx, this);
  ...