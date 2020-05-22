private int curPosi;

@Override
public void onBindViewHolder(final ViewHolder holder, final int position) {
holder.tvTitle.setText(data.get(position).getTitle());



holder.itemView.setOnClickListener(new OnClickListener() {
  @Override
  public void onClick(View view) {

  curPosi = position

  //Initializing the custom dailog
    final Dialog dialog = new Dialog(context);
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
    dialog.getWindow() .setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
    dialog.getWindow().getAttributes().gravity = Gravity.TOP;
    dialog.setContentView(R.layout.dailog);
    dialog.show();

    ImageView RightArrow = (ImageView) dialog.findViewById(R.id.dia_right_arrow);
    ImageView LeftArrow = (ImageView) dialog.findViewById(R.id.dia_left_arrow);
    final TextView textViewTitle = (TextView) dialog.findViewById(R.id.dia_tvTtile);


    textViewTitle.setText(data.get(position).getTitle());

    RightArrow.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

         int lastIndex = data.size()-1;

        if (lastIndex == curPosi ) { // this prevents the crash, so if the next button is clicked while the last index is showing it will reset and show the first one..!
          curPosi = 0;
        } else if(curPosi < data.size()) {
          curPosi++;
        }

     textViewTitle.setText(data.get(curPosi).getTitle());
      }
    });

    LeftArrow.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

       //same thing here with this "if", when the previous button clicked from the first; it will show the last item..!  
         if (curPosi == 0) { 
          curPosi = data.size();
        }

        if (curPosi > 0) {
          curPosi--;
        }

      textViewTitle.setText(data.get(curPosi).getTitle());

      } });
  }});

 }