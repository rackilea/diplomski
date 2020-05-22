public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.CustomViewHolder> implements Filterable {

    private List<CollegeItem> collegeList;
    private List<CollegeItem> collegeListFull;
    private ItemClickListener itemClickListener;
    private Context context;
    private DatabaseCollege collegeDB;

    public CustomRecyclerAdapter(List<CollegeItem> collegeList, Context context) {
        this.collegeList = collegeList;
        this.context = context;
        collegeListFull = new ArrayList<>(collegeList);
    }

    @NonNull
    @Override
    public CustomRecyclerAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.college_item, parent, false);
        return new CustomRecyclerAdapter.CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomRecyclerAdapter.CustomViewHolder holder, int position) {
        final String id = collegeList.get(position).getId();
        final String name = collegeList.get(position).getName();
        holder.name.setText(collegeList.get(position).getName());
        holder.id.setText(collegeList.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return collegeList.size();
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public Filter getFilter() {
        return collegeFilter;
    }

    public Filter getFilterName() {
        return collegeFilterName;
    }

    private Filter collegeFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<CollegeItem> filteredList = new ArrayList<>();

            if(constraint == null || constraint.length() == 0) {
                filteredList.addAll(collegeListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for(CollegeItem college : collegeListFull) {
                    if(college.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(college);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            collegeList.clear();
            collegeList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    private Filter collegeFilterName = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<CollegeItem> filteredList = new ArrayList<>();

            if(constraint == null || constraint.length() == 0) {
                filteredList.addAll(collegeListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for(CollegeItem college : collegeListFull) {
                    if(college.getId().toLowerCase().contains(filterPattern)) {
                        filteredList.add(college);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            collegeList.clear();
            collegeList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name, id;
        Button details; // Button should be here

        public CustomViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.college_name);
            id = v.findViewById(R.id.college_id);
            details = v.findViewById(R.id.btn_college_details);

            details.setOnClickListener(this); // set click listener here instead
        }

        @Override
        public void onClick(View v) {
            if(itemClickListener != null) {
                itemClickListener.onClick(v, getAdapterPosition());
            }
        }
    }
}