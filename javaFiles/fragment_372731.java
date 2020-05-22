public class ClosestShrutiDialog extends AlertDialog {

    private String mLessonId;
    private Activity mActivity;
    private View mParentView;

    private OnClickedListener mOnClickListerner;

    public ClosestShrutiDialog(@NonNull Activity activity, final String lessonId, final View parentView) {
        super(activity);
        this.mLessonId = lessonId;
        this.mActivity = activity;
        this.mParentView = parentView;

        setupView();
    }

    public void setmOnClickListerner(OnClickedListener mOnClickListerner) {
        this.mOnClickListerner = mOnClickListerner;
    }


    private void setupView() {

        // My business login to decide the msg related params ....

        // showing message to user to select the alternate shruti ...
        final String msg = mActivity.getResources().getString(R.string.user_alternate_shruti_msg,
                userShrutiLabel,
                closestShruti.getLabel());

        this.setMessage(msg);
        this.setButton(android.support.v7.app.AlertDialog.BUTTON_POSITIVE,
                mActivity.getResources().getString(R.string.yes),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        if(mOnClickListerner != null) {
                            mOnClickListerner.proceedWithChange(closestShruti);
                        }
                    }
                });
        this.setButton(android.support.v7.app.AlertDialog.BUTTON_NEGATIVE,
                mActivity.getResources().getString(R.string.cancel),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
    }

    public interface OnClickedListener {
        void proceedWithChange(final Shruti closestShruti);
    }
}