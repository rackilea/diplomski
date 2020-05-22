public class PropertyActivity extends Activity implements TextWatcher{

     @Override
    protected void onCreate(Bundle savedInstanceState) {

    propertyname = (AutoCompleteTextView) findViewById(R.id.et_propertyact_propertyname);
                propertyname.addTextChangedListener(this);
                blockname = (AutoCompleteTextView) findViewById(R.id.et_propertyact_blockname);
                blockname.addTextChangedListener(this);
                apartmentname = (AutoCompleteTextView) findViewById(R.id.et_propertyact_appartmentname);
                apartmentname.addTextChangedListener(this);
    }

        @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                PropAdapter = new ArrayAdapter<String>(PropertyActivity.this,R.layout.my_autolist_item,arr_Prop_name);
            //  propertyname.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
                propertyname.getDropDownBackground().setAlpha(255);
                propertyname.setThreshold(1);
                propertyname.setAdapter(PropAdapter);

                BlockAdapter = new ArrayAdapter<String>(PropertyActivity.this,R.layout.my_autolist_item,arr_block_name);
             // blockname.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
                blockname.getDropDownBackground().setAlpha(255);
                blockname.setThreshold(1);
                blockname.setAdapter(BlockAdapter);

                ApartmentAdapter = new ArrayAdapter<String>(PropertyActivity.this,R.layout.my_autolist_item,arr_apartment_name);
             // apartmentname.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
                apartmentname.getDropDownBackground().setAlpha(255);
                apartmentname.setThreshold(1);
                apartmentname.setAdapter(ApartmentAdapter);
            }
    }