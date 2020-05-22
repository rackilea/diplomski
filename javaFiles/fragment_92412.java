CardView cardView;
TextView cheese_name;
TextView cheese_origin;

public CheeseViewHolder(CardView v) {
    super(v);
    cardView = v;
    cheese_name = (TextView) cardView.findViewById(R.id.cheese_name);
    cheese_origin = (TextView) cardView.findViewById(R.id.cheese_origin);
    // and so on...
}