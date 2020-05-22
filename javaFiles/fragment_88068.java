class Tiger implements Animal { }

class Emu implements Animal { }

class Zoo {
    void add(Animal animal) { }
}

Zoo zoo = new Zoo();
zoo.add(new Tiger());
zoo.add(new Emu());