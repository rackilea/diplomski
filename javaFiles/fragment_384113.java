public class NoteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView textViewTitle;
    public TextView textViewContent;
    public ImageButton removeButton;
    public ImageButton editButton;

    public NoteViewHolder(View itemView, final NoteEditListener listener) {
        super(itemView);

        textViewTitle = itemView.findViewById(R.id.txt_title);
        textViewContent = itemView.findViewById(R.id.txt_note);
        removeButton = itemView.findViewById(R.id.btn_remove);
        editButton = itemView.findViewById(R.id.btn_edit);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.edit(getAdapterPosition());
            }
        }
     }