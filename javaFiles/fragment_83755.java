@Override
public void onCreate(final Bundle bundle) {
  super.onCreate(bundle);
  setContentView(randomLayout());

  RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
  // ...
}

public static int randomLayout() {
  final int n[] = { R.layout.layout1, R.layout.layout2, R.layout.layout3, R.layout.layout4 }
  Random random = new Random();
  return n[random.nextInt(n.length)];
}