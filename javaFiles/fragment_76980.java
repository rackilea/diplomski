itemView.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View view) {
        int position = getAdapterPosition();

        Intent intent = new Intent(context, singleActivity.class);
        hisItem clickeditem = mhislist.get(position);
        String pos = String.valueOf(position);
        intent.putExtra("CARD_NUMBER", pos);
        intent.putExtra("HEAD_LINE", clickeditem.getText1());
        intent.putExtra("REAL_NUMBER", clickeditem.getText3());
        startActivity(intent);
    }
});