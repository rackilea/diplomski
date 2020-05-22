public class ButtonListener implements View.OnClickListener {
        MainActivity activity;

        public ButtonListener(MainActivity activity) {
            this.activity = activity;   
        }
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(activity, ActivityOne.class);
            activity.startActivity(intent);
        }
    }