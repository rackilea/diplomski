public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {
private ViewClickCallBack viewClickCallBack;


private List<Model> models;

public GridAdapter(ViewClickCallBack viewClickCallBack) {
    this.viewClickCallBack = viewClickCallBack;
}

    class GridViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;


        public GridViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text_some);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (viewClickCallBack != null) {
                        Log.e("Element Index", "" + getAdapterPosition());
                        /**
                         * Increment the position by 1, as getAdapterPosition will
                         * return the index (count starts from 0) of the element.
                         * Hence, to simplify, we will increment the index by one,
                         * so that when we calculate the second last element, we will
                         * check the difference for 1.
                         * */
                        viewClickCallBack.viewClicked(getAdapterPosition() + 1);
                    }
                }
            });
        }
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid_view, parent, false);

        return new GridViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {
        Model model = getModel(position);
        if (model.isUploaded()) {
            holder.textView.setText("-");
        } else {
            holder.textView.setText("+");
        }

    }

    @Override
    public int getItemCount() {
        if (models != null) {
            return models.size();
        }
        return 0;
    }

    private Model getModel(int position) {
        if (models != null) {
            return models.get(position);
        }
        return null;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }
}