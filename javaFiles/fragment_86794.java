public class AskQuestions extends Fragment {

    private Button selectAnswer; 
    private TextView displayAnswer;
    private Spinner spinner;
    public String result;

    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }

    public void onCreate(Bundle savedInstabceState){
        super.onCreate(savedInstabceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        //Fetching layout
        View rootView = inflater.inflate(R.layout.fragment_questions, container, false);

        selectAnswer  = (Button) rootView.findViewById(R.id.button1);

        displayAnswer = (TextView) rootView.findViewById(R.id.textView1);

        spinner = (Spinner) rootView.findViewById(R.id.planets_spinner);




        //Setting spinner to custom class I created
        spinner.setOnItemSelectedListener(new OnItemSelectedListener (){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos,
             long id) {
                switch (pos) {
                case 0:     
                    displayAnswer.setText("You selected index 0");
                    break;
                case 1:
                    displayAnswer.setText("You selected index one");
                    break; 
                case 2: 
                    displayAnswer.setText("You selected index 2");
                    break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
            }
        });



        //Button clicks when the user selects an item of the spinner, and changes the text
        //based on what item is selected.
        selectAnswer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                        //This is where I am confused.
                        result = getResult();

                        displayAnswer.setText(result);              

            }
        });


        return rootView;
    }



}