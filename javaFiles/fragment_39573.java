public class SearchResultsAdapter extends  RecyclerView.Adapter<SearchResultsAdapter.CustomViewHolder>{
    private List<User> users;

    Context context;

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView userFN, userUN;

        public CustomViewHolder(View view) {
            super(view);
            userFN = (TextView) view.findViewById(R.id.userFullName);
            userUN = (TextView) view.findViewById(R.id.userUsername);

            // when userUN is clicked, then go to their profile
            userUN.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    userUN.setText("this text was clicked");
                    if (context instanceOf MainNavigation) {
                        ((MainNavigation) context).userFragment();
                    }
                }
            });
        }
    }

    public SearchResultsAdapter(Context context, List<User> users){
        this.context = context;        
        this.users = users;
    }

    @Override
    public SearchResultsAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.users_list, parent, false);

        return new SearchResultsAdapter.CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SearchResultsAdapter.CustomViewHolder holder, int position) {
        User user = users.get(position);
        String uFN = user.getFirstName() + " " + user.getLastName();
        holder.userFN.setText(uFN);
        holder.userUN.setText(user.getUsername());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}