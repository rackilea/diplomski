View theView;
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
 theView = inflater.inflate(R.layout.fragment_list_batches, container,false);
LinearLayout.LayoutParams SVView = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
LinearLayout SV = (LinearLayout)theView .findViewById(R.id.listBatchesRelative);
TextView batchName = new TextView(theView.getContext);
int i = 1;
batchName.setId(Integer.valueOf(i));
batchName.setText("Dynamic Input view");
batchName.setLayoutParams(SVView);
SV.addView(batchName);
return theView