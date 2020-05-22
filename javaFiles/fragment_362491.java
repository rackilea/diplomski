CardView cv;

        public AttendanceViewHolder(View itemView){
            super(itemView);
                Log.d("abcd","attendanceviewholder reached");
                vhyear = itemView.findViewById(R.id.year);
                cv = itemView.findViewById(R.id.card_view);
    ...
        }