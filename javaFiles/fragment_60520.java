public class WithLongAdapter extends SimpleCursorAdapter {
    private int[] mFrom;
    private int[] mTo;
/**
 * SimpleCursorAdapter that also checks for Double values based on rows so they will not be truncated
 * @param context pass this
 * @param layout the row file
 * @param c the Cursors
 * @param from collums on cursor
 * @param to rows on list
 */
    public WithLongAdapter(Context context, int layout, Cursor c,
            String[] from, int[] to) {
        super(context, layout, c, from, to);
        mTo = to; //have to make my own to and from because they are protected in SimpleCursorAdapter
        if (c != null) {
            int i;
            int count = from.length;
            if (mFrom == null || mFrom.length != count) {
                mFrom = new int[count];
            }
            for (i = 0; i < count; i++) {
                mFrom[i] = c.getColumnIndexOrThrow(from[i]);
            }
        } else {
            mFrom = null;
        }
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        final ViewBinder binder = getViewBinder();
        final int count = mTo.length;
        final int[] from = mFrom;
        final int[] to = mTo;

        for (int i = 0; i < count; i++) {
            final View v = view.findViewById(to[i]);
            if (v != null) {
                boolean bound = false;
                if (binder != null) {
                    bound = binder.setViewValue(v, cursor, from[i]);
                }

                if (!bound) {
                    String text = cursor.getString(from[i]);
                    if (text == null) {
                        text = "";
                    } else if (R.id.row_db_latitude == v.getId()) { //added rows, if they are the ones I want get value of doulbe
                        text = String.valueOf(cursor.getDouble(from[i]));
                    }
                    else if (R.id.row_db_longitude == v.getId()) { //added row
                        text = String.valueOf(cursor.getDouble(from[i]));
                    }
                    if (v instanceof TextView) {
                        setViewText((TextView) v, text);
                    } else if (v instanceof ImageView) {
                        setViewImage((ImageView) v, text);
                    } else {
                        throw new IllegalStateException(
                                v.getClass().getName()
                                        + " is not a "
                                        + " view that can be bounds by this SimpleCursorAdapter");
                    }
                }
            }
        }
    }
}