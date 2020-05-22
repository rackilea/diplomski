public class FreeSpaceActivity extends Fragment implements OnClickListener {

    EditText tPowerEdit = null;
    EditText tGainEdit = null;
    EditText rGainEdit = null;
    EditText freqEdit = null;
    EditText distanceEdit = null;
    EditText lightEdit = null;
    Button calButton = null;
    Button graphButton = null;
    Button clearButton = null;
    Button plotButton = null;
    Switch switchButton=null;

    EditText radEdit = null;//testing

    private ScrollView llLayout;
    private FragmentActivity faActivity;
    //private Switch switch1;
    // Changes here
    private double mResult = 0;
    private Switch mSelectUnit;
    private TextView mTextFreeSpaces;
    private boolean mIsCalculated;// flag to show the result only when you click on calculate button


    //@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        faActivity = (FragmentActivity) this.getActivity();
        llLayout = (ScrollView) inflater.inflate(R.layout.activity_free_space, container, false);

        tPowerEdit = (EditText)llLayout.findViewById(R.id.editText1);
        tGainEdit = (EditText)llLayout.findViewById(R.id.editText2);
        rGainEdit = (EditText)llLayout.findViewById(R.id.editText3);
        freqEdit = (EditText)llLayout.findViewById(R.id.editText4);
        distanceEdit = (EditText)llLayout.findViewById(R.id.editText7);
        lightEdit = (EditText)llLayout.findViewById(R.id.editText8);
        calButton = (Button)llLayout.findViewById(R.id.button1);
        calButton.setOnClickListener(this);
        graphButton = (Button)llLayout.findViewById(R.id.button2);
        graphButton.setOnClickListener(this);
        clearButton = (Button)llLayout.findViewById(R.id.button3);
        clearButton.setOnClickListener(this);
        plotButton =(Button)llLayout.findViewById(R.id.plot_button);
        plotButton.setOnClickListener(this);

        radEdit = (EditText)llLayout.findViewById(R.id.editText28);//testing

        // Changes here
        mTextFreeSpaces = (TextView) llLayout.findViewById(R.id.textFreeSpaces)

        mSelectUnit =(Switch)llLayout.findViewById(R.id.switch1);
        mSelectUnit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    updateFreeSpacesText(isChecked);
                }
            });
        return llLayout;
    }

    /*private ActionBar getSupportActionBar() {
        return null;
    }*/

    private void updateFreeSpacesText(boolean isSwitcherChecked) {
        if(mIsCalculated){
           if(isSwitcherChecked){
                mTextFreeSpaces.setText(Double.toString(mResult));
           } else {
                mTextFreeSpaces.setText(Double.toString(10 * Math.log10(mResult* 1000)));
           }
        }

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        String tPowerStr = tPowerEdit.getText().toString();
        String tGainStr = tGainEdit.getText().toString();
        String rGainStr = rGainEdit.getText().toString();
        String freqStr = freqEdit.getText().toString();
        String distanceStr = distanceEdit.getText().toString();
        String lightStr = lightEdit.getText().toString();
        double tPower = Double.parseDouble(!tPowerStr.isEmpty() ? tPowerStr : "0");
        double tGain = Double.parseDouble(!tGainStr.isEmpty() ? tGainStr : "0");
        double rGain = Double.parseDouble(!rGainStr.isEmpty() ? rGainStr : "0");
        double freq = Double.parseDouble(!freqStr.isEmpty() ? freqStr : "0");
        double distance = Double.parseDouble(!distanceStr.isEmpty() ? distanceStr : "0");
        double light = Double.parseDouble(!lightStr.isEmpty() ? lightStr : "0");

        String radStr = radEdit.getText().toString();//testing
        double radius = Double.parseDouble(!radStr.isEmpty() ? radStr : "0");//testing


        if (v == calButton) {
            double lamda = 300000000 / freq;

            mResult = tPower * tGain * rGain * Math.pow(lamda / (4 * Math.PI * distance), 2) / light / 100;
          mIsCalculated = true;
          updateFreeSpacesText(mSelectUnit.isChecked());


        }
        else if (v == graphButton) {

            Intent intent = new Intent(getActivity(), GraphActivity.class);
            intent.putExtra("model", "freeSpace");
            intent.putExtra("tp", tPower);
            intent.putExtra("tg", tGain);
            intent.putExtra("rg", rGain);
            intent.putExtra("f", freq);
            intent.putExtra("l", light);
            this.startActivity(intent);
        } else if (v == clearButton) {
            ((EditText) llLayout.findViewById(R.id.editText1)).setText("");
            ((EditText) llLayout.findViewById(R.id.editText2)).setText("");
            ((EditText) llLayout.findViewById(R.id.editText3)).setText("");
            ((EditText) llLayout.findViewById(R.id.editText4)).setText("");
            ((EditText) llLayout.findViewById(R.id.editText7)).setText("");
            ((EditText) llLayout.findViewById(R.id.editText8)).setText("");
            ((EditText) llLayout.findViewById(R.id.editText28)).setText("");
            ((TextView) llLayout.findViewById(R.id.textFreeSpaces)).setText("");
            //((TextView) llLayout.findViewById(R.id.textFreeSpacePrd)).setText("");
        } else if (v == plotButton) {
            //double radius = Double.parseDouble(radius.getText().toString());
            Intent intent = new Intent(getActivity(), MapActivity.class);
            Bundle b = new Bundle();
            b.putDouble("radius", result);
            intent.putExtras(b);
            this.startActivity(intent);
            }
        }



}