public void addTo(String recipient){
  // validate recipient
  this.to.add(recipient);
}

public String removeTo(String recipient){
  return this.to.remove(recipient);
}

public boolean hasTo(){
  return this.to.size() > 0;
}