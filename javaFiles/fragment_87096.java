public class GenericClickListener implements View.OnClickListener {
    public GenericClickListener(Activity activity, Class<? extends AppCompatActivity> activityClass) {
        @Override
        public void onClick(View v) {
            Intent activityIntent = new Intent(activity, activityClass);
            startActivity(activityIntent);
        }
    } 
}