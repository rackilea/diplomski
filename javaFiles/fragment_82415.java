public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    EditText editText;
    Button button;

    public ViewHolder(View itemView) {
        super(itemView);

        editText = itemView.findViewById(R.id.editText);
        button = itemView.findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.button:
                String text = editText.getText().toString();
                break;
        }
    }
}