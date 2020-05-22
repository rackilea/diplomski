public class MyViewController {
         private Context context;
         public MyViewController(Context context) {
              this.context = context;
         }

         public Spinner getSpinner() {
             return new Spinner(context);
         }

         public ArrayAdapter getAdapter(int resId, String[] values) {
            return new ArrayAdpter(context, resId, values);
         }
    }