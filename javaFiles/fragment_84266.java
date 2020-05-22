public class YourClass extends Activity implements View.OnClickListener

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Component setup here. 
        nRecyclerView = (RecyclerView) findViewById(R.id.my_recycler2_view);
        nRecyclerView.setHasFixedSize(true);
        nRecyclerView.setOnClickListener(this);
    }    

    @Override
    public void onClick(View v) {
        checkWhich(v);
    }

    private static void checkWhich (View v){
        int selectedItemPosition = nRecyclerView.getChildPosition(v);
        RecyclerView.ViewHolder nViewHolder = nRecyclerView.findViewHolderForPosition (selectedItemPosition);

        TextView textViewName = (TextView) nViewHolder.itemView.findViewById(R.id.textViewCountry);
        String selectedName = textViewName.getText().toString();
        for (int i = 0; i  < MyData.countryArray.length; i++){
            if (selectedName==MyData.countryArray[i]) {
                System.out.println(selectedName);
            }
        }
    }
}