public class AdaptadorX extends RecyclerView.Adapter<AdaptadorX.ViewHolder> {
private ArrayList<Items> itemsLi;
private Context context;
pruvate OnImageClickListener listener;

interface OnImageClickListener{
    void onSelected(String url);
}

public static class ViewHolder extends RecyclerView.ViewHolder{
    public ImageView idSrcImagen;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        idSrcImagen = itemView.findViewById(R.id.idImagen);
    }
}

public AdaptadorX(ArrayList<Items> itemsListado, Context context_L, OnImageClickListener listener){
    itemsLi = itemsListado;
    context = context_L;
    this.listener = listener;
}

@NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, parent, false);
    ViewHolder content = new ViewHolder(view);
    return content;
}

@Override
public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
    final Items contarItems =  itemsLi.get(position);
    Glide.with(context).load(contarItems.getxNombre_imagen()).into(holder.idSrcImagen);
    holder.idSrcImagen.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            listener.onSelected(contarItems.getxNombre_imagen())
        }
    });
}

@Override
public int getItemCount() {
    Log.d("Mensaje_Size_Tamaño", String.valueOf(itemsLi.size()));
    return itemsLi.size();
}