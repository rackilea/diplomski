public class CurrentAffairs extends AppCompatActivity {
public static int correct, wrong, marks;
DbH db;
ArrayList<Question> mcqs;
Cursor cur;
ListView lv;
CustomAdapter c;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.current_affairs);
    lv = (ListView) findViewById(R.id.lv);
    mcqs = new ArrayList<>();

    try {
        db = new DbH(this);
    } catch (IOException e2) {
        e2.printStackTrace();
    }
    try {
        db.createdatabase();
    } catch (IOException e) {
        e.printStackTrace();
    }
    db.opendatabase();
    cur = db.data();
    try {
        while (cur.moveToNext()) {
            String mcqss = cur.getString(1);
            String opta = cur.getString(2);
            String optb = cur.getString(3);
            String optc = cur.getString(4);
            String optd = cur.getString(5);
            String answ = cur.getString(6);

            Question question = new Question();
            question.question = mcqss;
            question.option1 = opta;
            question.option2 = optb;
            question.option3 = optc;
            question.option4 = optd;
            question.correctanxer = answ;
            mcqs.add(question);


           c = new CustomAdapter(CurrentAffairs.this, R.layout.row,    R.id.mcqsText, mcqs);
            lv.setAdapter(c);
        }
    } finally {
        cur.close();
    }
    Button btnshow = (Button) findViewById(R.id.btnshowresult);
    btnshow.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            StringBuffer sb = new StringBuffer();
            sb.append("Correct Answer = " + " " + correct);
            sb.append("    " + "Wrong Answer = " + " " + wrong);
            sb.append("    " + "Final Score = " + " " + correct * 5);

            Toast.makeText(CurrentAffairs.this, sb, Toast.LENGTH_SHORT).show();
        }
    });
}



class CustomAdapter extends ArrayAdapter<Question> {

    public CustomAdapter(Context context, int resource, int textViewResourceId, ArrayList<Question> objects) {
        super(context, resource, textViewResourceId, objects);


    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.row, parent, false);
        TextView mcqsText = (TextView) v.findViewById(R.id.mcqsText);
        TextView ans2 = (TextView) v.findViewById(R.id.answer2);
        TextView anss = (TextView) v.findViewById(R.id.answer);
        RadioGroup rg = (RadioGroup) v.findViewById(R.id.radioGroup);

        RadioButton opt1 = (RadioButton) v.findViewById(R.id.optA);
        RadioButton opt2 = (RadioButton) v.findViewById(R.id.optB);
        RadioButton opt3 = (RadioButton) v.findViewById(R.id.optC);
        RadioButton opt4 = (RadioButton) v.findViewById(R.id.optD);

        Question question = mcqs.get(position);

        mcqsText.setText(question.question);
        opt1.setText(question.option1);
        opt2.setText(question.option2);
        opt3.setText(question.option3);
        opt4.setText(question.option4);
        anss.setText(question.selectedanxer);
        ans2.setText("Correct answer is = " + question.correctanxer);

        String test=opt1.getText().toString();
        String test2=question.selectedanxer+"";

        if (test.equals(""+test2)){
            opt1.setChecked(true);
        }
        if (test2.equals(opt2.getText()+"")){
            opt2.setChecked(true);
        }
        if (test2.equals(opt3.getText()+"")){
            opt3.setChecked(true);
        }
        if (test2.equals(opt4.getText()+"")){
            opt4.setChecked(true);
        }




        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                Question question1=mcqs.get(position);
                RadioButton radioButton= (RadioButton) group.findViewById(checkedId);
                mcqs.get(position).selectedanxer=radioButton.getText().toString();
                notifyDataSetChanged();



            }
        });

        return v;
    }
}

public class Question {
    String question;
    String option1;
    String option2;
    String option3;
    String option4;

    String selectedanxer;
    String correctanxer;

}

}