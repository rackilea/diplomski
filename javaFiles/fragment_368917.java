@Override
public void onAttach(Activity activity)
{
    super.onAttach(activity);

    try
    {
        mListener = (SelectProblemDialogListener) getTargetFragment();
        if (mListener == null)
        {
            mListener = (SelectProblemDialogListener) activity;
        }
    } catch (ClassCastException e)
    {
        throw new ClassCastException("Must implement SelectProblemDialogListener");
    }
}