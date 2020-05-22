if (x=firstLibrary){
    System.out.println("You successfully borrowed The Lord of the Rings");
    firstLibrary.remove("The Lord of the Ring");
} else if (x=secondLibrary){
    System.out.println("Sorry, this book is not in our catalog.");
} else {
    System.out.println("Sorry, this book is already borrowed.");
}