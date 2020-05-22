public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> implements Filterable {
private Context context;
LayoutInflater layoutInflater;
List<Model> modeller;
List<Model> filteredModel;


public CustomAdapter(Context context, List<Model> models) {
    this.context = context;
    this.modeller = models;
    this.filteredModel = models;  // bu sekilde ekliyoruz

}


@NonNull
@Override
public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    layoutInflater = LayoutInflater.from(context);
    View v = layoutInflater.inflate(R.layout.row_list, parent, false);
    return new ViewHolder(v);
}

@Override
public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {

    holder.name.setText(filteredModel.get(position).getName());
    holder.packageName.setText(filteredModel.get(position).getPackageName());
    holder.developer.setText(filteredModel.get(position).getDeveloperName());
    holder.price.setText(filteredModel.get(position).getPrice() + " " + "€");
    holder.rating.setText(String.valueOf(filteredModel.get(position).getRatingValue()));
    Picasso.get().load(filteredModel.get(position).getIconUrl()).into(holder.image_icon);

    holder.linearLayout.setTag(holder);

    holder.linearLayout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ViewHolder viewHolder = (ViewHolder) v.getTag();
            int position = holder.getAdapterPosition();

            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            String pName = filteredModel.get(position).getPackageName();
            String sabit = "https://play.google.com/store/apps/details?id=";
            String uzanti = sabit + pName;
            intent.setData(Uri.parse(uzanti));
            context.startActivity(intent);
        }
    });

}

@Override
public int getItemCount() {
    return filteredModel.size();
}


@Override
public Filter getFilter() {

    return new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            String searchString = charSequence.toString();
            if (searchString.isEmpty()) {

                filteredModel = modeller;

            } else {

                ArrayList<Model> tempFilteredList = new ArrayList<>();

                for (Model model : modeller) {

                    // search for user name
                    if (model.getName().toLowerCase().contains(searchString)) {

                        tempFilteredList.add(model);
                    }
                }
                filteredModel = tempFilteredList;
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredModel;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            filteredModel = (ArrayList<Model>) filterResults.values;
            notifyDataSetChanged();
        }
    };
}


public class ViewHolder extends RecyclerView.ViewHolder {
    TextView name, packageName, developer, rating, price;
    LinearLayout linearLayout;
    ImageView image_icon;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.text_name);
        packageName = itemView.findViewById(R.id.text_packagename);
        developer = itemView.findViewById(R.id.text_developer);
        rating = itemView.findViewById(R.id.text_rating);
        price = itemView.findViewById(R.id.text_price);
        image_icon = itemView.findViewById(R.id.image_icon);

        linearLayout = itemView.findViewById(R.id.linear_layout);

    }
}