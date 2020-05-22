class ViewHolder extends RecyclerView.ViewHolder{
    TextView selectedAnswer;
    RadioGroup radioGroup;

    boolean isBinding;

    ViewHolder(View itemView) {
        super(itemView);

        radioGroup = itemView.findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int position = getAdapterPosition();

                RadioButton radioButton = (RadioButton) group.findViewById(checkedId);

                /* Only update the model when onCheckedChange() was initiated by the user clicking
                   a radio button, not when the adapter is binding the view. In that scenario, we
                   are only interested in passing information FROM the model TO the view. */
                if( !isBinding ) {
                    models.get(position).setChecked(checkedId);
                    models.get(position).setSelectedAns(radioButton != null ? radioButton.getText().toString() : "");
                }

                selectedAnswer.setText(  models.get(position).getSelectedAns() );
            }
        });

        ...
    }
}