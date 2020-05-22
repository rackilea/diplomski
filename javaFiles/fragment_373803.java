public class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentRecyclerAdapter.CustomViewHolder> {


    private List<Student> studentListItemList;
    private Context mContext;
    private StudentsFragment students;
    private Set<Integer> studensToBeRemoved;
    private List<Boolean> selected;


    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            CustomViewHolder holder = (CustomViewHolder) view.getTag();
            int pos = holder.getAdapterPosition();
            if (studensToBeRemoved.size() == 0) {
                Student studentListItem = studentListItemList.get(pos);
                Bundle extras = new Bundle();
                extras.putInt("id", studentListItem.getId());
                extras.putString("name", studentListItem.getName());
                extras.putString("surname", studentListItem.getSurname());
                extras.putLong("date", studentListItem.getLongBirthday());
                extras.putString("photo", studentListItem.getImage());


                    Intent intent = new Intent(mContext, ProfileStudent.class);
                    intent.putExtras(extras);
                    mContext.startActivity(intent);




            } else {
                if (!selected.get(pos)) {
                    holder.stud_card_view.setCardBackgroundColor(Color.GREEN);
                    studensToBeRemoved.add(studentListItemList.get(pos).getId());
                    selected.set(pos, true);
                } else {
                    holder.stud_card_view.setCardBackgroundColor(Color.WHITE);
                    studensToBeRemoved.remove(studentListItemList.get(pos).getId());
                    selected.set(pos, false);

                }
                if (studensToBeRemoved.size() > 0)
                    students.onMethodCallback(true);
                else
                    students.onMethodCallback(false);
            }
        }
    };

    private View.OnLongClickListener longClickListener = view -> {

        final CustomViewHolder holder = (CustomViewHolder) view.getTag();
        int pos = holder.getAdapterPosition();

        if (!selected.get(pos)) {
            holder.stud_card_view.setCardBackgroundColor(Color.GREEN);
            studensToBeRemoved.add(studentListItemList.get(pos).getId());
            selected.set(pos, true);
        } else {
            holder.stud_card_view.setCardBackgroundColor(Color.WHITE);
            studensToBeRemoved.remove(studentListItemList.get(pos).getId());
            selected.set(pos, false);

        }
        if (studensToBeRemoved.size() > 0)
            students.onMethodCallback(true);
        else
            students.onMethodCallback(false);


        return true;
    };


    public StudentRecyclerAdapter(Context context, List<Student> studentListItemList, Students students) {
        this.studentListItemList = studentListItemList;
        this.mContext = context;
        this.studensToBeRemoved = new HashSet<>();
        this.students = students;
        selected = new ArrayList<>();
        for (int i = 0; i < studentListItemList.size(); i++)
            selected.add(false);
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.student_list_row, null);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        Student studentListItem = studentListItemList.get(i);
        Picasso.with(mContext).load(studentListItem.getImage())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(customViewHolder.imageView);

        customViewHolder.textView.setText(studentListItem.getName() + " " + studentListItem.getSurname());
        customViewHolder.stud_card_view.setTag(customViewHolder);
        customViewHolder.edit_button.setTag(customViewHolder);
        customViewHolder.stud_card_view.setOnClickListener(clickListener);
        if (!selected.get(i))
            customViewHolder.stud_card_view.setCardBackgroundColor(Color.WHITE);
        else
            customViewHolder.stud_card_view.setCardBackgroundColor(Color.GREEN);

        customViewHolder.stud_card_view.setOnLongClickListener(longClickListener);
        customViewHolder.stud_card_view.setOnClickListener(clickListener);
        customViewHolder.edit_button.setOnClickListener(clickListener);

    }

    @Override
    public int getItemCount() {
        return (null != studentListItemList ? studentListItemList.size() : 0);
    }

    public void setFilter(ArrayList<Student> newList) {
        studentListItemList = new ArrayList<>();
        studentListItemList.addAll(newList);
        notifyDataSetChanged();

    }

    public Set<Integer> getStudensToBeRemoved() {
        return studensToBeRemoved;
    }

    public void setSelected(boolean b) {
        if (b) {
            for (int i = 0; i < selected.size(); i++) {
                studensToBeRemoved.add(studentListItemList.get(i).getId());
                selected.set(i, true);
            }

            students.onMethodCallback(true);

        } else {
            for (int i = 0; i < selected.size(); i++) {
                selected.set(i, false);
                studensToBeRemoved.remove(studentListItemList.get(i).getId());
            }
            students.onMethodCallback(false);

        }
        notifyItemRangeChanged(0, getItemCount());

    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected ImageView imageView;
        protected TextView textView;
        protected CardView stud_card_view;
        protected ImageButton edit_button;

        public CustomViewHolder(View view) {
            super(view);
            this.imageView = view.findViewById(R.id.stud_list_pic);
            this.textView = view.findViewById(R.id.stud_list_name);
            this.stud_card_view = view.findViewById(R.id.stud_card_view);
            this.edit_button = view.findViewById(R.id.student_edit_btn);
            edit_button.bringToFront();
        }
    } 
}