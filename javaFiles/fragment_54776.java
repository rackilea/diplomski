public class MainActivity extends AppCompatActivity implements TextWatcher{

    EditText txtEntry;
    boolean IsChanged = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtEntry = (EditText) findViewById(R.id.txtEntry);
        txtEntry.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
        txtEntry.addTextChangedListener(this);


    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        String ss = "";
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

        if (IsChanged)
            return;
        IsChanged = true;

        String sInput =editable.toString().replace(" ","@space@");

        SpannableStringBuilder ObjBuilder = new SpannableStringBuilder();
        ObjBuilder.append(sInput);

        while (true)
        {
            int iStartIndex = sInput.indexOf("@space@");
            int iEndIndex = iStartIndex + "@space@".length();

            if (iStartIndex == -1)
                break;
            sInput = sInput.replaceFirst("@space@","[space]");
            Drawable ObjDraw = getResources().getDrawable(R.drawable.space);
            ObjDraw.setBounds(0,0,10,60);
            ImageSpan Image = new ImageSpan(ObjDraw);
            ObjBuilder.setSpan(Image,iStartIndex,iEndIndex,0);
        }

        editable.clear();
        editable.append( ObjBuilder);
        txtEntry.setSelection(txtEntry.getText().length());


        IsChanged = false;
    }
}