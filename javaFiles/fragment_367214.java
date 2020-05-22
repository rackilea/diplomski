public class CustomAdapter extends ArrayAdapter<ListModel> implements
    OnClickListener {

   public CustomAdapter(Context context, List<ListModel> dataset) {
       super(context, R.id.list, dataset);
   }