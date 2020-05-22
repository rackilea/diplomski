public class UserA extends User {
    @Override public void clearAgenda() {
        super.clearAgenda(); // do the stuff common to all User subclasses
        ... // do stuff specific to A
    }
}