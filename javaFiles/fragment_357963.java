public class AnimalDecorator {

    static interface Animal {
        public String makeNoise();
            public void wagTail();
            //other methods
    }   
    static class Dog implements Animal {
        public final String makeNoise() { return "woof"; }
        public final void wagTail() { //do wag tail action }
    }
    static class DogDecorator implements Animal {
            //delegate
            private Animal animal;

            public DogDecorator (Animal animal){this.animal = animal;}
        public String makeNoise() { animal.makeNoise();}
            public void wagTail() { animal.wagTail();}

    }

    static class LoudDog extends DogDecorator {
        @Override public String makeNoise() {
            return "WOOF WOOF WOOF!!!";
        }
    }
}