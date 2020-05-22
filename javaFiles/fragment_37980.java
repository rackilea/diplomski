public class UpgEditText extends EditText {
    public UpgEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public UpgEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UpgEditText(Context context) {
        super(context);
    }

    TextWatcher watcher = null;

    public void setOnTextChangedListener(final int position, final Adapter_edit adapter) {
        if (watcher != null) {
            this.removeTextChangedListener(watcher);
        }

        watcher = new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    adapter.itemsArrayList.get(position).setBonus(
                            Integer.parseInt(s.toString()));
                }
                catch (Exception e) {
                }
            }
        };
        this.addTextChangedListener(watcher);
    }
}