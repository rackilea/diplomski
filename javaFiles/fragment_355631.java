public ViewHolder(View itemView) {
    super(itemView);
    itemView.setOnClickListener(this);
    imageView = (NetworkImageView) itemView.findViewById(R.id.imageViewHero);
    textViewName = (TextView) itemView.findViewById(R.id.textViewName);
    textViewPublisher = (TextView) itemView.findViewById(R.id.textViewPublisher);
}

@Override
public void onClick(View view) {
    // here you can get your item by calling getAdapterPosition();
    SuperHero superHero =  superHeroes.get(getAdapterPosition());
}