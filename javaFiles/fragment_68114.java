public static void main(String[] args) {
        // TODO code application logic here
    nameInput();
    popularityNumber();
}

public static void nameInput() {

    System.out.println("What is the name of the cartoon character : ");
    Scanner keyboard = new Scanner(System.in);
    CartoonStar star = new CartoonStar();
    String name = keyboard.next();
    star.setName(name);

    typeInput(keyboard, star);
}