public abstract class BaseActivity extends AppCompatActivity {

    private static Integer backgroundColor;

    @Override
    public void onResume {
        super.onResume();

        upgradeBackgroundColor();
    }

    public void updateBackgroundColor() {
        if(backgroundColor != null) {
            getWindow().getDecorView().setBackgroundColor(backgroundColor);
        }
    }
    public void changeAppBackground(int color) {
        backgroundColor = color;
    }
}