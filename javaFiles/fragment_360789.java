@Override
public void onDismiss(DialogInterface dialog) {
    super.onDismiss(dialog);

    if (getTargetFragment() instanceof FragmentA)
        ((FragmentA) getTargetFragment()).doReload();

}