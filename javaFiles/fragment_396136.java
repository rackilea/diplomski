public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView name;
    public TextView roll;
    public TextView previous;

    RadioGroup radioAttendance;
    RadioButton radioAttendancePresent, radioAttendanceAbsent;


    public CardView card_view;


    public ViewHolder(View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.textViewAttendanceStudentName);
        roll = (TextView) itemView.findViewById(R.id.textViewAttendanceStudentRoll);
        previous = (TextView) itemView.findViewById(R.id.textViewAttendanceStudentPreviousStatus);
        radioAttendance = itemView.findViewById(R.id.radioAttendance);
        radioAttendancePresent = itemView.findViewById(R.id.radioAttendancePresent);
        radioAttendanceAbsent = itemView.findViewById(R.id.radioAttendanceAbsent);

        radioAttendancePresent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioAttendancePresent.setChecked(true);
                listItems.get(getAdapterPosition()).setAttendance("present");
            }
        });

        radioAttendanceAbsent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioAttendanceAbsent.setChecked(true);
                listItems.get(getAdapterPosition()).setAttendance("absent");
            }
        });

    }

    void bind(int position) {
        // use the sparse boolean array to check
        if (listItems.get(position).getAttendance() != null) {
            if (listItems.get(position).getAttendance().equals("present")) {
                radioAttendancePresent.setChecked(true);
            } else if (listItems.get(position).getAttendance().equals("absent")) {
                radioAttendanceAbsent.setChecked(true);
            }
        } else {
            radioAttendance.clearCheck();
        }

        name.setText(listItems.get(position).getName());
        roll.setText(listItems.get(position).getRoll());
        previous.setText(listItems.get(position).getPreviousAttendance());
    }
}