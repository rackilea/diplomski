public class Main2Activity extends AppCompatActivity 
                           implements RadioGroup.OnCheckedChangeListener {

    private static final double[][] values = {{0, 0.3, 0.16, 0.17, 0.12, 0.37},   //first radio button values
                                              {0, 0.23, 0.12, 0.13, 0.13, 0.27}}; //second radio button values

    Spinner kcpt;
    double kcptjalan;
    /*
     * your other attributes...
     **/


    /*
     * your other methods...
     **/

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        if(checkedId == R.id.RA){
            kcpt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    kcptjalan = values[0][position];
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
        if (checkedId == R.id.RB){
            kcpt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                    kcptjalan = values[1][position];
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }
}