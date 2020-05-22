public class ExampleViewHolder extends RecyclerView.ViewHolder {

    private final FrameLayout mBackground;
    private final TextView mTextView;

    public ExampleViewHolder(View itemView) {
        super(itemView);

        mBackground = (FrameLayout) itemView.findViewById(R.id.background);
        mTextView = (TextView) itemView.findViewById(R.id.textView);
    }

    public void bind(ExampleModel model) {
        mBackground.setBackgroundColor(model.getColor());
        mTextView.setText(model.getText());
    }
}