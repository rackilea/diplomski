public class NumberPickerDialog extends DialogFragment {

    private SomethingSelectedListener listener;

    public interface SomethingSelectedListener {
        void numbersSelected(int[] numbers);
    }

    ...

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        listener = (SomethingSelectedListener) context;
    }

}