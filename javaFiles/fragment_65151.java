public class PopupFragment extends AppCompatDialogFragment {

@Override
public Dialog onCreateDialog(Bundle savedInstanceState) {

    View v = LayoutInflater.from(getActivity())
            .inflate(R.layout.info_popup, null);

    final TextView link = v.findViewById(R.id.linkText);
    link.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            link.setMovementMethod(LinkMovementMethod.getInstance());
        }
    });

    return new AlertDialog.Builder(getActivity())
            .setView(v)
            .create();
}
}