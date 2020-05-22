// start fragment
public static class PlaceholderFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {

        // Use the layout which is displayed it's fragment_main.xml
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        // Find your views here!
        // Don't forget to findViewById attached to the inflated view "rootView.findView..."
        pepBox = (CheckBox) rootView.findViewById(R.id.checkBox1);
        cheeseBox = (CheckBox) rootView.findViewById(R.id.checkBox2);
        textView = (TextView) rootView.findViewById(R.id.textView1);

        /*
         * Do something here: click listener, set a text, check a box..
        */

        return rootView;
    }  

    /*
     * Perform other methods still inside the fragment
    */ 
    public void onButton1Click(View v){
        if(v.getId() == R.id.button1){

            StringBuilder str = new StringBuilder("");
            if (pepBox.isChecked()) {
                str.append("Pepperoni"+" ");
            }
            if (cheeseBox.isChecked()) {
                str.append("Extra Cheese");
            }
            if (str.length() == 0) {
                str.append("Plain");
            }
            textView.setText(str);
        }
    }
}
// end fragment