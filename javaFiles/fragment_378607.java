public class ClassRVAdapter extends RecyclerView.Adapter<ClassRVAdapter.ClassViewHolder> {

    private List<ClassesBean> mClasses;
    Context mContext;

    public static class ClassViewHolder extends RecyclerView.ViewHolder {

        TextView mClassName;
        TextView mTeachers;

        public ClassViewHolder(final Context context, View v, final List<ClassesBean> classes) {
            super(v);
            mClassName = (TextView) v.findViewById(R.id.classname);
            mTeachers = (TextView) v.findViewById(R.id.teachers);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    long id = classes.get(getAdapterPosition()).getId();
                    Toast.makeText(context,"You Clicked ID = " + String.valueOf(id), Toast.LENGTH_SHORT).show();
                }
            });
            v.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    ((MainActivity) context).removeAt(getAdapterPosition(),classes.get(getAdapterPosition()).getId());
                    return true; // Mark event as having been handled
                }
            });
        }
    }

    public ClassRVAdapter(Context context, List<ClassesBean> classes) {
        mContext = context;
        mClasses = classes;
    }

    @Override
    public ClassRVAdapter.ClassViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.class_list_item, parent, false);
        return new ClassViewHolder(mContext,v,mClasses);
    }

    @Override
    public void onBindViewHolder(ClassViewHolder vh, int position) {
        vh.mClassName.setText(mClasses.get(position).getClasses_name());
        vh.mTeachers.setText(mClasses.get(position).getClasses_teachers());    
    }

    @Override
    public int getItemCount() {
        return mClasses.size();
    }
}