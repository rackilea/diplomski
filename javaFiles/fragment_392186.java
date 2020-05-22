protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);     

// further code

int[] actionbarColor = context.getResources().getIntArray(R.array.actionbar_color);
actionBar.setBackgroundDrawable(new ColorDrawable(getRandom(actionbarColor)));
}

public int getRandom(int[] array) {
int rnd = new Random().nextInt(array.length);
return array[rnd];
}