public static void main(String[] args) {
    Character John = new Character("John", 0);
    workout(John, 5);
}

public static void workout(Character character, int byAmt) {
    // use a setter to set the attribute
    character.setStr(character.getStr() + byAmt);
}

class Character {
   private String name;
   private int Str;
   public Character(String n, int initialStr) {
       name = n;
       Str = initialStr;
   }
   public String getName() {
       return name;
   }
   public void setName(String name) {
       this.name = name;
   }
   public int getStr() {
       return Str;
   }
   public void setStr(int str) {
       Str = str;
   }
}