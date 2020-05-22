class Performer extends Person {
     List<Capability> capabilities;
}

// Perhaps call it 'Skills'
interface Capability {
     public void play();
}

class Pianist implements Capability {
     public void play() {
         // ....
     }
}

class Singer implements Capability {
     public void play() {
         sing();
     }

     public void sing() {
         // ....
     }
}