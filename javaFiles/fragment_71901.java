@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(Bundle savedInstanceState);
    timer = new Timer();
    timer.schedule(new Task(this), 0, 2000);
}