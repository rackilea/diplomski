public class ExampleDialog extends AppCompatDialogFragment {

    // Create constant values for each key in dialog's arguments.
    private static final String ARGUMENT_TITLE = "title";
    private static final String ARGUMENT_POSITIVE = "positive";
    private static final String ARGUMENT_MESSAGE = "message";
    private static final String ARGUMENT_POSITIVE_TEXT = "positive_text";
    private static final String ARGUMENT_NEGATIVE = "negative";
    private static final String ARGUMENT_NEGATIVE_TEXT = "negative_text";

    private ExampleDialogListener listener;
    private String title;
    private String positive;
    private String message;
    private String positivetext;
    private String negative;
    private String negativetext;

    /**
     * Create a new instance of ExampleDialog, providing
     * title, message, positive, positivetext, negative, negativetext as arguments.
     */
    public static ExampleDialog newInstance(String title, String positive, String message,
                                            String positivetext, String negative, String negativetext) {
        Bundle args = new Bundle();
        // Store all arguments into bundle.
        args.putString(ARGUMENT_TITLE, title);
        args.putString(ARGUMENT_POSITIVE, positive);
        args.putString(ARGUMENT_MESSAGE, message);
        args.putString(ARGUMENT_POSITIVE_TEXT, positivetext);
        args.putString(ARGUMENT_NEGATIVE, negative);
        args.putString(ARGUMENT_NEGATIVE_TEXT, negativetext);
        ExampleDialog fragment = new ExampleDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        // Retrieve all arguments from bundle here.
        title = getArguments().getString(ARGUMENT_TITLE);
        positive = getArguments().getString(ARGUMENT_POSITIVE);
        message = getArguments().getString(ARGUMENT_MESSAGE);
        positivetext = getArguments().getString(ARGUMENT_POSITIVE_TEXT);
        negative = getArguments().getString(ARGUMENT_NEGATIVE);
        negativetext = getArguments().getString(ARGUMENT_NEGATIVE);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title)
                .setMessage(message)
                .setNegativeButton(negative, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast = Toast.makeText(getContext(), negativetext, Toast.LENGTH_SHORT);
                        toast.show();
                    }
                })
                .setPositiveButton(positive, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast = Toast.makeText(getContext(), positivetext, Toast.LENGTH_SHORT);
                        toast.show();
                        listener.onYesClicked();
                    }
                });
        return builder.create();
    }

    public interface ExampleDialogListener {
        void onYesClicked();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener = (ExampleDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + "must implement ExampleDialogListener");
        }
    }
}