public static void main(String[] args) {
        Food dogFood = new Food("meat", "beef");
        doSomethingWithAnimal(new Animal("Max", dogFood)); // <-- anonymous creation of an Animal
        //problem: get animal from dogfood
        Animal theAnonymousAnimal = //get it via reflection from dogFood
    }