public class OuterClass extends CustomAppCompatActiivity {
    private EditText city_et;

    public static class InnerClass extends DialogFragment {
        private EditText city_et;

        public InnerClass(EditText city_et) { // Pass a reference in
            this.city_et = city_et;
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            okBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //the view to access
                    city_et.setText("");

                    getDialog().dismiss();
                }
            });
        }
    }
}