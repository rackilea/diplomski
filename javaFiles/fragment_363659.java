class Animal {
    public void makeSound() {
        System.out.println("Beep!");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Miaow!");
    }
}