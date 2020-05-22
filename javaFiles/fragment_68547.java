class Animal { ... }

interface Wildlife { ... }
interface Domestic { ... }

class WildAnimal
    extends Animal
    implements Wildlife
{ ... }

class DomesticAnimal
    extends Animal
    implements Domestic
{ ... }

class Zoo
{
    void add(WildAnimal beast) { ... }
    void add(DomesticAnimal beast) { ... }
}