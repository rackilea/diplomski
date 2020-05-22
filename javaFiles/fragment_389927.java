public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {

    private ArrayList<Users_get> cities;
    public int position;
    IItemClick listener;
    public UsersAdapter(ArrayList<Users_get> cities,IItemClick listener ) {
        this.cities = cities;
        this.listener = listener
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout_cart, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Users_get city = cities.get(position);
        holder.name.setText(city.getName());
        holder.surname.setText(city.getSurname());
        holder.price.setText(Long.toString(city.getPrice()));
        holder.name.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
         listener.onItemClick(city.getKey(), position);
        }

    }

    @Override
    public int getItemCount() {
        if (cities != null) {
            return cities.size();
        } else {
            return 0;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View view;
        public final TextView name;
        public final TextView surname;
        public final TextView price;


        public ViewHolder(View view) {
            super(view);
            this.view = view;
            name = view.findViewById(R.id.name_text2);
            surname = view.findViewById(R.id.status_text2);
            price = view.findViewById(R.id.price2);
    }
}