@Override
public void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    if (savedInstanceState != null) {
        isOn = savedInstance.getBoolean("EXTRA_IS_ON");
    }
}