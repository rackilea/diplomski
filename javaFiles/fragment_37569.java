...
@Override
public Dialog onCreateDialog(Bundle savedInstanceState) {
    String title = getArguments().getString("title");
    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
    alertDialogBuilder.setTitle(title);
    alertDialogBuilder.setMessage("Are you sure?");
    alertDialogBuilder.setPositiveButton("OK",  new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            // on success
            ((MainActivity)(MyAlertDialogFragment.this.getActivity())).onDialogOKPressed();
        }
    });
    alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            getTargetFragment().onActivityResult(getTargetRequestCode(), 1, getActivity().getIntent());
            dialog.dismiss();
        }
    });

    return alertDialogBuilder.create();
}