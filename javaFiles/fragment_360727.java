public Titi(){
  this.toto = new Toto();     
}

/** For testing only. Uses the passed Toto instance instead of a new one. */
Titi(Toto toto){
  this.toto = toto;
}