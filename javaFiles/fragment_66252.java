public class NoteAdapter extends ListAdapter<Note, NoteAdapter.NoteHolder> {

....
Context context;
@NonNull
@Override
public NoteHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    context = viewGroup.getContext();
View itemView = LayoutInflater.from(context).inflate(R.layout.note_item, viewGroup, false);
    return new NoteHolder(itemView);
}

@Override
public void onBindViewHolder(@NonNull NoteHolder noteHolder, int i) {
    Note currentNote = getItem(i);
    noteHolder.textViewTitle.setText(currentNote.getTitle());
    noteHolder.textViewDescription.setText(currentNote.getDescription());

    Glide.with(context)
            .load(Uri.parse(currentNote.getImageUri()))
            .fit()
            .centerCrop()
            .into(noteHolder.image);

}

....

}