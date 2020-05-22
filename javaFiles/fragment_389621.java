public class OuterClass extends CustomAppCompatActiivity {
    private EditText city_et;
    private final InnerClass inner = new InnerClass();
    public class InnerClass extends DialogFragment {
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

    public InnerClass getInnerClass() {
        return inner;
    }
}