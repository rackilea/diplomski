public class SearchAdapter  extends RecyclerView.Adapter<SearchAdapter.SearchHolder>{

Context context;
ArrayList<Accordo> chords;

public class SearchHolder extends RecyclerView.ViewHolder {

    //VIEWS
    TextView nome;

    public SearchHolder(View view){
        super(view);
        this.nome = (TextView) view.findViewById(R.id.ricerca_nome);
    }
}

public SearchAdapter(Context ctx, ArrayList<Accordo> chords){
    this.context = ctx;
    this.chords = chords;
    //        this.filterList = chords;
}


@Override
public SearchHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    // convert xml to View Object
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_row, parent, false);

    return new SearchHolder(v);
}

@Override
public void onBindViewHolder(SearchHolder holder, int position) {

    //BIND DATA
    holder.nome.setText(chords.get(position).getName());

}

@Override
public int getItemCount() {
    return chords.size();
}

public void setFilter(List<Accordo> accordoList) {
    chords = new ArrayList<>();
    chords.addAll(accordoList);
    notifyDataSetChanged();
}