public class MyDialogFragment {
    private Returning returning;

    buttUpdate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            returning= ((Returning ) context);
            returning.return_value("everything");
            // ...
        }
    }
}