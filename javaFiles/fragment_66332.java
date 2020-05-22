int templateID = 1, inflatedID = 0, setImageViewID = 10, buttonID = 1, imageViewId;
Button b, target, bNext, testTemplate, mStartActivityButton, browseButton;
View v1, insertPoint;
RelativeLayout.LayoutParams templateParams;
LayoutInflater vi;
ImageView thumbnailContainer;
private TextView mFilePathTextView;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.make_question);
    Initialize();
}

public void Initialize(){
    //button for adding new forms
    b = (Button) findViewById(R.id.makeLayoutButton);
    b.setOnClickListener(this);

    bNext = (Button) findViewById(R.id.bNext);
    bNext.setOnClickListener(this);

    //get the template form to be duplicated, v1 is the form layout to be duplicated
    vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    v1 = vi.inflate(R.layout.form_template, null);

    //container where forms will be contained in
    insertPoint = findViewById(R.id.questionsContainer);

    // Set the views
    mFilePathTextView = (TextView)findViewById(R.id.file_path_text_view);
    mStartActivityButton = (Button)findViewById(R.id.start_file_picker_button);
    mStartActivityButton.setOnClickListener(this);    
}

public void onClick(View v) {

    if(v.getId() == R.id.makeLayoutButton){

        v1 = vi.inflate(R.layout.form_template, null);

        ((LinearLayout) insertPoint).addView(v1);

        mStartActivityButton = (Button)v1.findViewById(R.id.start_file_picker_button);
        mStartActivityButton.setId(buttonID);

        mStartActivityButton.setOnClickListener(this);

        thumbnailContainer = (ImageView)v1.findViewById(R.id.imgView);
        thumbnailContainer.setId(setImageViewID);

        buttonID++;
        setImageViewID++;
    }

    for(int x=1;x<=10;x++){
            if(v.getId() == x){
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, v.getId());

        }
    }


    if(v.getId() == R.id.bNext){
        Intent b = new Intent(MakeQuestion.this, ChoosingTarget.class);
        startActivity(b);
    }

}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (resultCode == RESULT_OK && null != data) {
        Uri selectedImage = data.getData();
        String[] filePathColumn = { MediaStore.Images.Media.DATA };

        Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
        cursor.moveToFirst();

        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        String picturePath = cursor.getString(columnIndex);
        cursor.close();

        ImageView imageView = (ImageView)findViewById(requestCode + 9);

        imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));   
    }
}