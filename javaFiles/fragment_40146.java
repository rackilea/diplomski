holder.my_button.setTag(holder);
holder.my_button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        ProgressHolder clickedHolder = (ProgressHolder)view.getTag();
        clickedHolder.deficiency_notes.setVisibility(View.GONE);

    }
});