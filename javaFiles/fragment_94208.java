public void load(){
  int j = 0;
  for (j = 0; j < 2; j++) {
    int i = 0;
    for (Color c : Color.values()) {
      for (Value v : Value.values())
        cards[i++] = new Card(c, v);
    }
  }
}