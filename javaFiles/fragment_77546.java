public TextView mTextView;
public TextView mTextView1;
public TextView mTextView2;
public TextView mTextView3;

 public ViewHolder(View itemView) {
    super(itemView);
    mTextView = (TextView)itemView.findViewById(R.id.grade);
    mTextView1 = (TextView)itemView.findViewById(R.id.grade1);
    mTextView2 = (TextView)itemView.findViewById(R.id.grade2);
    mTextView3 = (TextView)itemView.findViewById(R.id.grade3);
  }