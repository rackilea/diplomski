@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getID = new Random();
        allQuestions = new ArrayList<Question>();

        allQuestions.add(new Question(2, 0, 0, 2, 5, (BitmapFactory.decodeResource(getResources(), R.drawable.flag_dutch)), "The Netherlands", true)); //<-- error at this line
    }