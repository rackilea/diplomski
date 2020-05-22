class MenuAdapter extends ArrayAdapter<CharSequence> {

    public MenuAdapter(
            Context context, int textViewResId, CharSequence[] strings) {
        super(context, textViewResId, strings);
    }

    public static MenuAdapter createFromResource(
            Context context, int textArrayResId, int textViewResId) {

        Resources      resources = context.getResources();
        CharSequence[] strings   = resources.getTextArray(textArrayResId);

        return new MenuAdapter(context, textViewResId, strings);
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    public boolean isEnabled(int position) {
        // return false if position == position you want to disable
    }
}