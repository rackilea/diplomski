public class ListaAlunosActivity extends AppCompatActivity 
        implements View.OnClickListener {// <------ 1. implement OnClickListener

protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        LinearLayout questoesQuiz = (LinearLayout) findViewById(R.id.quiz);
        // Log.d(TAG,"Populate List View; Displaying Data in the List View");

        ArrayList<String> dataList = new ArrayList<>(Arrays.asList("sup1", "sup2", "sup3"));
        RadioGroup listaDeQuestoes = new RadioGroup(this);
        listaDeQuestoes.setOrientation(RadioGroup.VERTICAL);
        RadioGroup.LayoutParams lp;

        for (int i = 0; i < dataList.size(); i++) {
            RadioButton botao = new RadioButton(this);
            botao.setOnClickListener(this);//  <---------- 2.add this line
            botao.setText(dataList.get(i));
            lp = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.MATCH_PARENT, RadioGroup.LayoutParams.MATCH_PARENT);
            listaDeQuestoes.addView(botao, lp);
        }
        questoesQuiz.addView(listaDeQuestoes);
    }
@Override
public abstract void onClick (View v){ //<-------- 3. override onClick
   boolean checked = ((RadioButton) v).isChecked();


        final String TAG = "MyActivity";


        Log.v("On clicked working", "clicado");

        int id = v.getId();// your radio buttons have no id thus use title instead of id:
        String title = ((RadioButton) v).getText();


        Toast toast2 = Toast.makeText(this, "toast working", Toast.LENGTH_LONG);
        toast2.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
        toast2.show();
}