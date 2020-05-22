public class MyAdapter extends Adapter {
     private Context context;

     public MyAdapter(Context context) {
          this.context = context;     
     }

     public View getView(...){
         View v;
         v.setOnClickListener(new OnClickListener() {
             void onClick() {
                 context.startActivity(...);
             }
         });
     }
}