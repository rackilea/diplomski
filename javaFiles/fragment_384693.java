public class classname extends AppCompatActivity {

    Boolean text1= false;
    Boolean text2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Your code

        titleEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0 ){
                    text1 = true;
                    if(text1 && text2){
                        addButton.setEnabled(true);
                    }
                 }else{
                    text1 = false;
                    addButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        priceEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() >0 ){
                    text2 = true;
                    if(text1 && text2){
                        addButton.setEnabled(true);
                    }
                }else{
                    text2 = false;
                    addButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}