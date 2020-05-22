public class MainActivity extends AppCompatActivity implements RecyclerItemTouchHelper.RecyclerItemTouchHelperListener, NoteListAdapter.NotesAdapterListener {

private FirebaseAuth mFirebaseAuth;
public FirebaseUser mFirebaseUser;
private FirebaseFirestore db;

private RecyclerView recyclerView;
private RecyclerView.LayoutManager recyclerViewLayoutManager;
public NoteListAdapter adapter;
private List<Note> notesList = new ArrayList<>();

private ListenerRegistration firestoreListener;
private RecyclerItemTouchHelper.RecyclerItemTouchHelperListener listener;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    recyclerView = findViewById(R.id.rvNoteList);



}

@Override
public void onStart() {
    super.onStart();
    if (adapter != null) {
        adapter.startListening();
    }
}

@Override
public void onStop() {
    super.onStop();
    if (adapter != null) {
        adapter.stopListening();
    }
}

@Override
protected void onResume() {
    super.onResume();
    mFirebaseAuth = FirebaseAuth.getInstance();
    mFirebaseUser = mFirebaseAuth.getInstance().getCurrentUser();
    db = FirebaseFirestore.getInstance();

    if (adapter != null) {
        adapter.startListening();
    }
       FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build();
    db.setFirestoreSettings(settings);

    Query query = db.collection("users").document(firebase_user_uid).collection("notes");
    FirestoreRecyclerOptions<Note> response = new FirestoreRecyclerOptions.Builder<Note>().setQuery(query, Note.class).build();
    adapter = new NoteListAdapter(notesList, response, MainActivity.this, MainActivity.this);

    recyclerViewLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
    recyclerView.setLayoutManager(recyclerViewLayoutManager);
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    recyclerView.addItemDecoration(new CustomRecyclerViewDivider(this, LinearLayoutManager.VERTICAL, 16));

    recyclerView.setAdapter(adapter);

    ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, MainActivity.this);
    new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);

    firestoreListener = db.collection("users").document(firebase_user_uid).collection("notes")
            .addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                    if (e != null) {
                        Log.e("LOL", "Listen failed!", e);
                        return;
                    }

                    notesList.clear();

                    for (DocumentSnapshot doc : documentSnapshots) {
                        Note note = doc.toObject(Note.class);
                        note.setId(doc.getId());
                        notesList.add(note);
                    }
                }
            });

    recyclerView.addOnItemTouchListener(new RecyclerViewTouchListener(getApplicationContext(), recyclerView, new RecyclerViewTouchListener.ClickListener() {
        @Override
        public void onClick(View view, int position) {
            if (notesList != null || notesList.size() <= 0) {
                Note note = notesList.get(position);
                updateNote(note);
            }
        }

        @Override
        public void onLongClick(View view, int position) {

        }
    }))


}}