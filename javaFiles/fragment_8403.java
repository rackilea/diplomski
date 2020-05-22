// collect your resources in Lists
List<Integer> pics = Arrays.asList(R.drawable.elephant, R.drawable.giraffe, R.drawable.hog, R.drawable.lion, R.drawable.monkey, R.drawable.panda, R.drawable.pig, R.drawable.tiger);
List<Integer> buttonResources = Arrays.asList(R.id.bt1, R.id.bt2, R.id.bt3, R.id.bt4, R.id.bt5, R.id.bt6, R.id.bt7, R.id.bt8, R.id.bt9, R.id.bt10, R.id.bt11, R.id.bt12, R.id.bt13,R.id.bt14, R.id.bt15, R.id.bt16);
List<ImageButton> buttons = new ArrayList<ImageButton>();

// randomize order of the pictures
Collections.shuffle(pics);

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ingame);

    for(int i = 0; i < buttonResources.size(); i++)
    {
        ImageButton bt = findViewById(buttonResources.get(i));
        buttons.add(bt);

        bt.setBackgroundResource(pics.get(i/2)); // hack: integer division, works because the number of pictures is half the number of buttons
    }

    // access the buttons later like this:
    bt1 = buttons.get(0);
}