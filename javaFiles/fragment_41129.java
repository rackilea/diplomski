Mammal x = ...;

if (x instanceof Dog) {
   Dog d = (Dog) x;
   d.bark();
} else if (x instanceof Cat) {
   Cat c = (Cat) x;
   c.meow();
}
if (x != null) {
   x.lactate();
}