public String setName(String name){
  if(name == null){
      throw new InvalidNameException();
  }
  this.name = name;
}


public String getName(){
    if(this.name == null){
        return "No Name here";
    }
    return this.name;
}