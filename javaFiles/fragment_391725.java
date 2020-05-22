@Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_drop_down_list);
        lv_items = getResources().getStringArray(R.array.subjects_List);

        findViewsById();
        lView = (ListView) findViewById(R.id.ListView01);
// Set option as Multiple Choice. So that user can able to select more the  one option from list
        lView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice,    lv_items));
        lView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        button.setOnClickListener(this);
    }