public interface MyCallback{
    void callback(String name, String flag);
}

public class ListViewDialogFragment extends DialogFragment {



    MyCallback myCallback;
    EditText nameEditText;
    EditText flagEditText;

    public ListViewDialogFragment() {

    }

    public static ListViewDialogFragment newInstance(String title, MyCallback callback){
        ListViewDialogFragment fragment = new ListViewDialogFragment ();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        myCallback = callback;
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

    View rootView = getActivity().getLayoutInflater().inflate(R.layout.xml_we_just_created, null);
    nameEditText= (EditText) rootView.findViewById(R.id.dialog_name_edit_text);
    flagEditText= (EditText) rootView.findViewById(R.id.dialog_flag_edit_text);

    final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    builder.setView(rootView);

        String title = getArguments().getString("title");

        builder.setTitle(title);
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            String name = nameEditText.getText.toString();
            String flag = flagEditText.getText.toString();
            if(!name.equals("") && !flag.equals(""))
                myCallback.callback(name, flag);
        }
    });
    }
}