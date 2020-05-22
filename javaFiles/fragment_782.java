// Position is easy to separate:
class Cat { String catBreed; ... }
class House{ String streetAddress; ... }

class ElementWrapper implements Element{
   Point position;
   Object  theObject; // could hold Cat or House
   public Point getPosition() {return position;}
   // however, isWalkable is a bit tricky... see remark below
}