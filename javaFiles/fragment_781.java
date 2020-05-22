interface Element{
   public point getPosition();
   public boolean isWalkable();
}
class Cat implements Element{
   private Point position;
   private String catBreed; // example of cat-specific data
   public point getPosition() {return position;}
   public boolean isWalkable() {return true;} // cats can walk
   ...
}
class House implements Element{
   private Point position;
   private String streetAddress; // example of house-specific data
   public point getPosition() {return position;}
   public boolean isWalkable() {return false;} // houses cannot walk  
   ..
}

// Finally, using that common interface:
Element[] allGameObjects= {new Cat(...), new Cat(...), new House(...) };
for(Element e:allGameObjects) 
   draw(e, e.getPosition());