class Entity implements Comparable<Entity> {
    Pet pet;
    Person owner;
    Friend friend;
    boolean cat;

    Entity(Pet pet, Person owner, Friend friend, boolean cat) {
      this.pet = pet;
      this.owner = owner;
      this.friend = friend;
      this.cat = cat;
    }

    public int compareTo(Entity b) {
      return pet.getName().compareToIgnoreCase(b.pet.getName());
    }
 }