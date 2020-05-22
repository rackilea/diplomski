public void display()
{
    System.out.print("Enter the name of Cat: ");
    this.setName(input.nextLine());
    System.out.print("Enter the age of Cat: ");
    this.setAge(Integer.valueOf(input.nextLine()));
    System.out.print("Enter the weight of Cat: ");
    this.setWeight(Double.valueOf(input.nextLine()));
    System.out.print("Enter the breed of Cat: ");
    this.setBreed(input.nextLine());
    System.out.print("Does the cat have claws? True or False?: ");
    this.setDeclawed(!Boolean.valueOf(input.nextLine()));
}