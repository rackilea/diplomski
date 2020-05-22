public class MyFragment extends Fragment {
 View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.myfragment_view, container, false);

        //call loaddata

        loadData();
        return view;
    }
 public void loadData() {
File path = Environment.getExternalStorageDirectory();
File myExternalFile = new File(path.getAbsolutePath() + "/App_Folder/", "accounts.txt");
try {
    FileInputStream fis = new FileInputStream(myExternalFile);
    DataInputStream in = new DataInputStream(fis);
    BufferedReader br = new BufferedReader(new InputStreamReader(in));

    String strLine;
    while ((strLine = br.readLine()) != null) {
        accounts.add(strLine);
    }
    br.close();
    in.close();
    fis.close();
} catch (IOException e) {
    e.printStackTrace();
}

for (int i = 0; i < accounts.size(); i++) {
    String[] splitArray = accounts.get(i).split("//");

    String accountNameText = splitArray[0];
    String amountSavedText = splitArray[1];
    String goalText = splitArray[2];
    String percentText = splitArray[3];

    // get a reference for the TableLayout, 
    TableLayout table = (TableLayout)view.findViewById(R.id.accountTable);

    // create a new TableRow
    TableRow row = new TableRow(getContext());

    TextView accountName = new TextView(getContext());
    accountName.setText(accountNameText);

    TextView amountSaved = new TextView(getContext());
    amountSaved.setText(amountSavedText);

    TextView accountGoal = new TextView(getContext());
    accountGoal.setText(goalText);

    TextView accountPercent = new TextView(getContext());
    accountPercent.setText(percentText);

    row.addView(accountName);
    row.addView(amountSaved);
    row.addView(accountGoal);
    row.addView(accountPercent);

    table.addView(row);
}}}