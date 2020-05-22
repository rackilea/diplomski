...
System.out.print("How many books would you like to add? ");
int nbBooks = sc.nextInt();

for (int i = 0; i < nbBooks; i++) {
    this.inventory[this.inventorySize + i] = new Book();
}
this.inventorySize += nbBooks;