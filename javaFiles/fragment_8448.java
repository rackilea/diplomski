public ClickeableOptions(CardView cardView, Context cont, Class actTarget) {
    this.cardView = cardView;
    this.cont = cont;
    this.actTarget= actTarget;

    this.cardView.setOnClickListener(this);
}