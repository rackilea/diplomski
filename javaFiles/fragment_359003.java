public class EditPlayerAdapter extends ArrayAdapter {

    private EditPlayerAdapterCallback callback;

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        convertView = (LinearLayout) inflater.inflate(resource, null);    
        Score score = getItem(position);
        TextView txtName = (TextView) convertView.findViewById(R.id.nameEdit);
        txtName.setText(score.getName());
        Button b = (Button)convertView.findViewById(R.id.deletePlayer);
        b.setTag(position);
        b.setOnClickListener(new View.OnClickListener() {
                 public void onClick(View v) {

                     if(callback != null) {

                        callback.deletePressed(position);
                     }
                 }
         });
        return convertView;
    }

    public void setCallback(EditPlayerAdapterCallback callback){

        this.callback = callback;
    }


    public interface EditPlayerAdapterCallback {

        public void deletePressed(int position);
    }
}