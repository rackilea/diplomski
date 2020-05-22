/**
 * Bind an existing view to the data pointed to by cursor
 * @param view Existing view, returned earlier by newView
 * @param context Interface to application's global information
 * @param cursor The cursor from which to get the data. The cursor is already
 * moved to the correct position.
 */
public abstract void bindView(View view, Context context, Cursor cursor);